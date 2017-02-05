package com.lespinside.simplepanorama.view;

import android.util.AttributeSet;

import com.lespinside.simplepanorama.BuildConfig;
import com.lespinside.simplepanorama.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = {22})
public class SphericalViewTest {
    @Test
    public void givenZoomFactorAttribute_whenCreated_thenSetsDefaultZoomFactor() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.zoomFactor, "0.1").build();

        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.getDefaultZoomFactor()).isEqualTo(0.1f);
    }

    @Test
    public void givenYawAttribute_whenCreated_thenSetsDefaultZoomFactor() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.yaw, "0.1").build();

        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.getDefaultYaw()).isEqualTo(0.1f);
    }

    @Test
    public void givenPitchAttribute_whenCreated_thenSetsDefaultZoomFactor() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.pitch, "0.1").build();

        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.getDefaultPitch()).isEqualTo(0.1f);
    }

    @Test
    public void givenRotationSensibilityAttribute_whenCreated_thenSetsDefaultRotationSensibility() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.rotationSensibility, "0.1").build();

        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.getDefaultRotationSensibility()).isEqualTo(0.1f);
    }

    @Test
    public void givenEnableZoomAttribute_whenCreated_thenEnablesZoom() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableZoom, "true").build();
        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isZoomEnabled()).isTrue();

        attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableZoom, "false").build();
        subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isZoomEnabled()).isFalse();
    }

    @Test
    public void givenEnableInertiaAttribute_whenCreated_thenEnablesInertia() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableInertia, "true").build();
        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isInertiaEnabled()).isTrue();

        attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableInertia, "false").build();
        subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isInertiaEnabled()).isFalse();
    }

    @Test
    public void givenEnableAccelerometerAttribute_whenCreated_thenEnablesAccelerometer() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableAccelerometer, "true").build();
        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isAccelerometerEnabled()).isTrue();


        attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableAccelerometer, "false").build();
        subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isAccelerometerEnabled()).isFalse();
    }

    @Test
    public void givenEnableResetAttribute_whenCreated_thenEnablesReset() throws Exception {
        AttributeSet attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableReset, "true").build();
        SphericalView subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isResetEnabled()).isTrue();

        attributeSet = Robolectric.buildAttributeSet().addAttribute(R.attr.enableReset, "false").build();
        subject = new SphericalView(RuntimeEnvironment.application, attributeSet);

        assertThat(subject.isResetEnabled()).isFalse();
    }
}