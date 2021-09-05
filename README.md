# Android Curl Example

Minimal Android example for using `libopenssl` and `libcurl` with `NDK` and `JNI`.

Pay special attention to the directory **`app/src/main/cpp`** where most of the work resides.

## Mechanism

- Use Android NDK to compile C functions together with cross-compiled `libcurl` and `libopenssl` libs.
- Use JNI to connect C functions to Java functions.
- Load NDK compiled shared lib in Android app.
- Call Java functions which call C functions eventually and can use all the stuff `curl` and `openssl` provide.

## Compile openssl and curl for Android

See this repo: [openssl-curl-android](https://github.com/robertying/openssl-curl-android) for how to cross-compile those two libs.

For simplicity, I just copied the whole build directory from [openssl-curl-android](https://github.com/robertying/openssl-curl-android) to `app/src/main/cpp/libs`. You may find better ways to place pre-compiled libs or just build them on the fly.

## **Note**

I have removed actual built libs from Git. Remember to copy precompiled ones to `app/src/main/cpp/libs` to make the app build.
