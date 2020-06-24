SpringScan
==========

The SpringScan library is written in kotlin, so this would need the project to support the Kotlin language and its dependencies

```gradle
    implementation 'com.springscan.sdk:springscan:1.0.1'

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

Getting Started
---------------

As mentioned above the **login api has to be called first** to use most other api's, since the auth process needs to happen

## Login 
The login function accepts a username and password and returns a LoginResponse object in the callback
```kotlin
    SpringScan.getAPIInstance().login("email@domain.address", "password", object : APICallback<LoginResponse>{
        override fun onSuccess(t: LoginResponse) {
            //Use Login Response as needed
        }

        override fun onError(throwable: Throwable) {
            //Any error's obtained
        }
    })
```

## Upload
The upload function can be used to upload document images to SpringScan servers in return for a image url, it accepts a bitmap file as 
first parameter and a doc type and reference to indicate which document type you are uploading, the person id with which you want to
associate like Aadhar, Pan, Voter, Driving License, Face Image(Selfie) 

```kotlin
    SpringScan.getAPIInstance().upload(myCapturedImageBitmap, DocType.AADHAAR, "person_id", object: APICallback<UploadResponse>{
        override fun onSuccess(t: LoginResponse) {
                //Use Upload Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Initialize Person
The initialize function is used to initialize a person for the first time, the first param requires the image url of the front doc, the second 
param can be null or the backside image url, the third param accepts a face image or selfie url, this can be optional as well, the doc param needs

```kotlin
    SpringScan.getAPIInstance().initializePerson("Front Doc URL", "Back Image URL", "Face Image URL", DocType.DRIVING_LICENSE, object: APICallback<RootResponse>{
        override fun onSuccess(t: RootResponse) {
                //Use Root Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Update Document
The update doc function is similar to to initialize person, but this function is used to update an already added document, also the third parameter accepts a
person id instead of a face image url, for updating selfie use the updateSelfie method

```kotlin
    SpringScan.getAPIInstance().updateDoc("Front Doc URL", "Back Image URL", "Person ID", DocType.DRIVING_LICENSE, object: APICallback<RootResponse>{
        override fun onSuccess(t: RootResponse) {
                //Use Root Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Update Selfie
The update selfie accepts a selfie url and a person id and can be used to update the selfie of a person

```kotlin
    SpringScan.getAPIInstance().updateSelfie("Selfie URL", "Person ID", object: APICallback<RootResponse>{
        override fun onSuccess(t: RootResponse) {
                //Use Root Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Get Person
This function is used to get a person object by their person ID

```kotlin
    SpringScan.getAPIInstance().getPerson("Person ID", object: APICallback<RootResponse>{
        override fun onSuccess(t: RootResponse) {
                //Use Root Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Compare Selfie and Document
This function triggers an OCR check for the document of our choice of a person, it accepts a person id param and the type of doc
that needs to be checked

```kotlin
    SpringScan.getAPIInstance().compareSelfieAndDoc("Person ID", DocType.DRIVING_LICENSE, object: APICallback<CompareResult>{
        override fun onSuccess(t: CompareResult) {
                //Use Compare Result as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Aadhar Verification
This function triggers a government verification for aadhar and accepts the doc id

```kotlin
    SpringScan.getAPIInstance().verifyAadhaar("Document ID", object: APICallback<AadhaarResponse>{
        override fun onSuccess(t: AadhaarResponse) {
                //Use Aadhaar Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Aadhar verification without OCR
This function triggers a government verification for aadhar and accepts the aadhar id number and the person id to skip OCR

```kotlin
    SpringScan.getAPIInstance().verifyAadhaarWithoutOCR("Aadhar ID Number", "Person ID", object: APICallback<AadhaarResponse>{
        override fun onSuccess(t: AadhaarResponse) {
                //Use Aadhar ID Response as needed
        }

        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Pan Verification
This function triggers a government verification for pan cards and accepts the doc id

```kotlin
    SpringScan.getAPIInstance().verifyPan("Document ID", object: APICallback<PanResponse>{
        override fun onSuccess(t: PanResponse) {
                //Use Pan Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Pan verification without OCR
This function triggers a government verification for pan cards and accepts the date of birth, name on the card, pan card number and person id to do verification without OCR

```kotlin
    SpringScan.getAPIInstance().verifyPanWithoutOCR("Date of Birth", "Name on Card", "Pan ID Number", "Person ID", object: APICallback<PanResponse>{
        override fun onSuccess(t: PanResponse) {
                //Use Pan Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Driving License Verification
This function triggers a government verification for driving license and accepts the doc id

```kotlin
    SpringScan.getAPIInstance().verifyDrivingLicense("Document ID", object: APICallback<DLResponse>{
        override fun onSuccess(t: DLResponse) {
                //Use Driving License Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Driving License Verification without OCR
This function triggers a government verification for driving license and accepts the date of birth, name on the card, driving license number and person id to do verification without OCR

```kotlin
    SpringScan.getAPIInstance().verifyDrivingLicenseWithoutOCR("Date of Birth", "Name on Card", "Driving License Number", "Person ID", object: APICallback<DLResponse>{
        override fun onSuccess(t: DLResponse) {
                //Use Driving License Response as needed
        }
    
        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Voter ID Verification
This function triggers a government verification for voter id and accepts the doc id

```kotlin
    SpringScan.getAPIInstance().verifyVoterID("Document ID", object: APICallback<VoterIDResponse>{
        override fun onSuccess(t: VoterIDResponse) {
                //Use Voter ID Response as needed
        }

        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Voter ID Verification without OCR
This function triggers a government verification for voter id and accepts the name on card, DL number and person id

```kotlin
    SpringScan.getAPIInstance().verifyVoterIDWithoutOCR("Name on Card", "Voter ID Number", "Person ID", object: APICallback<VoterIDResponse>{
        override fun onSuccess(t: VoterIDResponse) {
                //Use Voter ID Response as needed
        }

        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Court Check
This function triggers a court check with the person id

```kotlin
    SpringScan.getAPIInstance().courtCheckWithPersonID("Person ID", object: APICallback<CourtResponse>{
        override fun onSuccess(t: CourtResponse) {
                //Use Court Response as needed
        }

        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

## Court Check Direct
This function triggers a court check directly by using the name of the person and the name of the person's father and the address of the person

```kotlin
    SpringScan.getAPIInstance().courtCheckDirect("Name of Person", "Father's Name", "Address", object: APICallback<CourtResponse>{
        override fun onSuccess(t: CourtResponse) {
                //Use Court Response as needed
        }

        override fun onError(throwable: Throwable) {
                //Any error's obtained
        }
    })
```

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
