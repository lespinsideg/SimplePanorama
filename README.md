SimplePanorama
===
SimplePanorama is android panorama view library that uses modified version of [panoramagl-android](https://code.google.com/archive/p/panoramagl-android/wikis/UserGuide.wiki#Introduction) library. You can find modified version [here](https://github.com/lespinsideg/panoramagl).

Download
----

**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

**Step 2.**  Add the dependency
```groovy
dependencies {
        compile 'com.github.lespinsideg:SimplePanorama:0.3.1'
}
```

Usage
----
### Setting layout xml

You can add `SphericalView` in your layout xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">
    <com.lespinside.simplepanorama.view.SphericalView
        android:id="@+id/spherical_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:enableZoom="false"/>
</LinearLayout>
```

### Call lifecycle methods in activity

And you should call `onResume`, `onPause`, `onDestroy` method in each lifecycle method.

```java
public class MainActivity extends AppCompatActivity {

    private SphericalView sphericalView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sphericalView = (SphericalView) findViewById(R.id.spherical_view);
        sphericalView.setPanorama(PLUtils.getBitmap(this, R.raw.sunset_at_pier), false);
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
}
```

### Attributes list
* enableZoom - enable zooming in/out with two fingers touch.
* enableReset - enable resetting zoom factor with three fingers touch.
* enableAccelerometer - enable accelerometer sensor to move panorama camera.
* enableInertia - enable inertia of panorama camera movement.
* yaw - set default yaw of panorama camera.
* pitch - set default pitch of panorama camera.
* zoomFactor - set default zoom factor of panorama camera.
* rotationSensibility - set default rotation sensibility of panorama camera.

### Sample activity
You can find a sample activity [here](https://github.com/lespinsideg/SimplePanorama/blob/master/sample/src/main/java/com/lespinside/simplepanorama/sample/MainActivity.java)

Supports
----

* supports spherical view
* only supports power of 2 image sizes : 2048 x 1024 , 1024 * 512 , 512 * 256 ...

License
----
```
Copyright 2016 kyuhyen hwang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```