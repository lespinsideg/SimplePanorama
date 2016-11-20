package com.lespinside.simplepanorama.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lespinside.simplepanorama.view.SphericalView;
import com.panoramagl.utils.PLUtils;

public class MainActivity extends AppCompatActivity {

    private SphericalView sphericalView;
    private Bitmap[] bitmaps = new Bitmap[2];

    private View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.button1:
                    changePanorama(0);
                    break;
                case R.id.button2:
                    changePanorama(1);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bitmaps[0] = PLUtils.getBitmap(this, R.raw.sunset_at_pier);
        bitmaps[1] = PLUtils.getBitmap(this, R.raw.sunset_at_pier_grey);

        sphericalView = (SphericalView) findViewById(R.id.spherical_view);
        sphericalView.setPanorama(bitmaps[0], true);

        findViewById(R.id.button1).setOnClickListener(buttonClickListener);
        findViewById(R.id.button2).setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sphericalView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        sphericalView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sphericalView.onDestroy();
    }

    private void changePanorama(int index) {
        sphericalView.setPanorama(bitmaps[index], true);
    }
}
