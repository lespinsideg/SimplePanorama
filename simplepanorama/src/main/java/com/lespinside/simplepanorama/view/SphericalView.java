package com.lespinside.simplepanorama.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import com.lespinside.simplepanorama.R;
import com.panoramagl.PLICamera;
import com.panoramagl.PLImage;
import com.panoramagl.PLManager;
import com.panoramagl.PLSphericalPanorama;

public class SphericalView extends RelativeLayout {
    private PLManager plManager;
    private float defaultPitch;
    private float defaultYaw;
    private float defaultZoomFactor;
    private float defaultRotationSensibility;
    private boolean init;

    public SphericalView(Context context) {
        this(context, null);
    }

    public SphericalView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SphericalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        plManager = new PLManager(context);
        plManager.setContentView(this);
        plManager.onCreate();

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SphericalView);
        boolean enableAccelerometer = typedArray.getBoolean(R.styleable.SphericalView_enableAccelerometer, false);
        boolean enableInertia = typedArray.getBoolean(R.styleable.SphericalView_enableInertia, false);
        boolean enableZoom = typedArray.getBoolean(R.styleable.SphericalView_enableZoom, true);
        boolean enableReset = typedArray.getBoolean(R.styleable.SphericalView_enableReset, true);
        defaultPitch = typedArray.getFloat(R.styleable.SphericalView_pitch, 4f);
        defaultYaw = typedArray.getFloat(R.styleable.SphericalView_yaw, 0f);
        defaultZoomFactor = typedArray.getFloat(R.styleable.SphericalView_zoomFactor, 0.7f);
        defaultRotationSensibility = typedArray.getFloat(R.styleable.SphericalView_rotationSensibility, 30f);

        typedArray.recycle();

        setAccelerometerEnabled(enableAccelerometer);
        setInertiaEnabled(enableInertia);
        setZoomEnabled(enableZoom);
        setResetEnabled(enableReset);
    }

    public void onResume() {
        plManager.onResume();
    }

    public void onPause() {
        plManager.onPause();
    }

    public void onDestroy() {
        plManager.onDestroy();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return plManager.onTouchEvent(event);
    }

    public void setPanorama(Bitmap bitmap, boolean keepCameraAngle) {
        PLSphericalPanorama panorama = new PLSphericalPanorama();
        panorama.setImage(new PLImage(bitmap, true));
        float pitch = defaultPitch;
        float yaw = defaultYaw;
        float zoomFactor = defaultZoomFactor;

        if(keepCameraAngle && init) {
            pitch = plManager.getCamera().getPitch();
            yaw = plManager.getCamera().getYaw();
            zoomFactor = plManager.getCamera().getZoomFactor();
        }

        panorama.getCamera().lookAtAndZoomFactor(pitch, yaw, zoomFactor, false);
        panorama.getCamera().setRotationSensitivity(defaultRotationSensibility);
        plManager.setPanorama(panorama);
        init = true;
    }

    public void setAccelerometerEnabled(boolean enabled) {
        plManager.setAccelerometerEnabled(enabled);
    }

    public boolean isAccelerometerEnabled() {
        return plManager.isAccelerometerEnabled();
    }

    public void setInertiaEnabled(boolean enabled) {
        plManager.setInertiaEnabled(enabled);
    }

    public boolean isInertiaEnabled() {
        return plManager.isInertiaEnabled();
    }

    public void setZoomEnabled(boolean enabled) {
        plManager.setZoomEnabled(enabled);
    }

    public boolean isZoomEnabled() {
        return plManager.isZoomEnabled();
    }

    public PLICamera getCamera() {
        return plManager.getCamera();
    }

    public float getDefaultPitch() {
        return defaultPitch;
    }

    public void setDefaultPitch(float defaultPitch) {
        this.defaultPitch = defaultPitch;
    }

    public float getDefaultYaw() {
        return defaultYaw;
    }

    public void setDefaultYaw(float defaultYaw) {
        this.defaultYaw = defaultYaw;
    }

    public float getDefaultZoomFactor() {
        return defaultZoomFactor;
    }

    public void setDefaultZoomFactor(float defaultZoomFactor) {
        this.defaultZoomFactor = defaultZoomFactor;
    }

    public float getDefaultRotationSensibility() {
        return defaultRotationSensibility;
    }

    public void setDefaultRotationSensibility(float defaultRotationSensibility) {
        this.defaultRotationSensibility = defaultRotationSensibility;
    }

    public void setResetEnabled(boolean enabled) {
        plManager.setResetEnabled(enabled);
    }

    public boolean isResetEnabled() {
        return plManager.isResetEnabled();
    }
}
