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

        typedArray.recycle();

        setAccelerometerEnabled(enableAccelerometer);
        setInertiaEnabled(enableInertia);
        setZoomEnabled(enableZoom);
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
        float pitch = 5f;
        float yaw = 0f;
        float zoomFactor = 0.8f;
        if(keepCameraAngle) {
            pitch = panorama.getPitch();
            yaw = panorama.getYaw();
            zoomFactor = panorama.getCamera().getZoomFactor();
        }
        panorama.getCamera().lookAtAndZoomFactor(pitch, yaw, zoomFactor, false);
        plManager.setPanorama(panorama);
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
}
