SimplePanorama
===
SimplePanorama is android panorama view library that uses [panoramagl-android](https://code.google.com/archive/p/panoramagl-android/wikis/UserGuide.wiki#Introduction) library.

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
        compile 'com.github.lespinsideg:SimplePanorama:0.1.1'
}
```

Usage
----

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

Supports
----

* supports spherical view
* only supports power of 2 image size : 2048 x 1024 , 1024 * 512 , 512 * 256 ...

License
----

   Copyright 2016 lespinside

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.