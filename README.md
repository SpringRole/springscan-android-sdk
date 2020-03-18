SpringScan
==========

The SpringScan library is written in kotlin, so this would need the project to support the Kotlin language and its dependencies

```gradle
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.4'
    implementation 'androidx.core:core-ktx:1.2.0'
    implementation 'com.squareup.retrofit2:retrofit:2.7.2'
    implementation "com.squareup.retrofit2:converter-gson:2.7.2"
    implementation "com.squareup.okhttp3:okhttp:4.4.0"
```

you would also need to include this in the main build.gradle file in the all projects section

```gradle
    allprojects {
        repositories {
            maven { url 'https://dl.bintray.com/springworks2020/Maven' }
        }
    }
```

Setup
-----

The SDK has to be initialized one before making any API calls using

SpringScan.initialize(this, "YOUR_COMPANY_TOKEN")

Then you can use the singleton instance SpringScan.getAPIInstance() to make use of our available api calls,
SpringScan.getAPIInstance().login(), should be called to generate the authentication token needed for most other calls

Acknowledgements
----------------

SpringScan uses the following open source libraries:

- [OkHttp](https://github.com/square/okhttp) - Copyright Square, Inc.
- [Gson](https://github.com/google/gson) - Copyright Google Inc.
- [Retrofit](https://square.github.io/retrofit/) - Copyright Square, Inc.

License
-------
    
    Copyright (C) 2020 Springworks

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
