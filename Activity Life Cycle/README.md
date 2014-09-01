App Life Cycle and Debugging
====

The goal is to understand how works an Android application, so as when it is created and destroyed.
It's also a great occasion to do your first steps in Android debugging.

The Rules
===

Create an android project and override the following methods in your main activity:

* `onCreate`
* `onStart`
* `onResume`
* `onPause`
* `onStop`
* `onDestroy`
* `onRestart`

In each of those methods, add a log (e.g `Log.d("LifeCycle", "methodName")`) and debug you application.
You should be able to observe and understand when and why each of those methods are called.

Getting Started
===

1. Create project `Activity Life Cycle`:
    * Package: `com.webridge.lifecycle`
    * Activity: `MyActivity`
2. Override the desired methods
    * IntelliJ can automatically override methods in the menu
        * `Code` -> `Override Methods...`