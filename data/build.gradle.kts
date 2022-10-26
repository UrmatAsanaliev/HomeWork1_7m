plugins {
    id(Dependencies.Plugins.androidLibrary)
    id(Dependencies.Plugins.jetbrainsKotlin)
    id (Dependencies.Plugins.kotlinKapt)
}

android {
    compileSdk = Dependencies.Config.compileSdk

    defaultConfig {
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk

        testInstrumentationRunner = Dependencies.Config.testInstrumentationRunner
        consumerProguardFiles(Dependencies.Config.consumerProguardFiles)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Dependencies.Config.jvmTarget
    }
}

dependencies {

    //Domain module
    implementation(project(":domain"))

    //Core module
    implementation(project(":core"))
    implementation(project(":core_ui"))

    //Javax Inject
    implementation(Dependencies.Javax.inject)

    implementation(Dependencies.UI.androidxCore)
    implementation(Dependencies.UI.androidxAppcompat)
    implementation(Dependencies.UI.androidMaterial)
    testImplementation(Dependencies.UI.junit)
    androidTestImplementation(Dependencies.UI.androidTest)
    androidTestImplementation(Dependencies.UI.androidTestEspresso)


    // Dagger-Hilt
    implementation (Dependencies.DaggerHilt.daggerHiltAndroid)
    kapt (Dependencies.DaggerHilt.daggerHiltCompiler)

    //Room
    implementation (Dependencies.Room.roomRuntime)
    annotationProcessor (Dependencies.Room.roomCompiler)
    kapt(Dependencies.Room.roomKaptCompiler)
    implementation(Dependencies.Room.roomKtx)

    // Networking
    val retrofit_version = "2.9.0"
    val okhttp_version = "4.7.2"
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.okhttp3:okhttp:$okhttp_version")
    implementation ("com.squareup.okhttp3:logging-interceptor:$okhttp_version")
}