plugins {
    id (Dependencies.Plugins.androidApplication)
    id (Dependencies.Plugins.jetbrainsKotlin)
    id (Dependencies.Plugins.googleDaggerHilt)
    id (Dependencies.Plugins.kotlinKapt)
}

android {
    compileSdk = Dependencies.Config.compileSdk

    defaultConfig {
        applicationId = Dependencies.Config.applicationId
        minSdk = Dependencies.Config.minSdk
        targetSdk = Dependencies.Config.targetSdk
        versionCode = Dependencies.Config.versionCode
        versionName = Dependencies.Config.versionName

        testInstrumentationRunner = Dependencies.Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Dependencies.Config.jvmTarget
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation (Dependencies.UI.androidxCore)
    implementation (Dependencies.UI.androidxAppcompat)
    implementation (Dependencies.UI.androidMaterial)
    implementation (Dependencies.UI.androidConstraint)
    testImplementation (Dependencies.UI.junit)
    androidTestImplementation (Dependencies.UI.androidTest)
    androidTestImplementation (Dependencies.UI.androidTestEspresso)
    implementation (Dependencies.UI.androidFragment)

    //LifeData
    implementation (Dependencies.LiveData.lifecycleViewModel)
    implementation (Dependencies.LiveData.lifecycleLiveData)
    implementation (Dependencies.LiveData.lifecycleRuntime)

    //Navigation
    implementation(Dependencies.Navigation.navigationFragment)
    implementation(Dependencies.Navigation.navigationUIKts)

    //room
    implementation (Dependencies.Room.roomRuntime)
    annotationProcessor (Dependencies.Room.roomCompiler)
    kapt(Dependencies.Room.roomKaptCompiler)
    implementation(Dependencies.Room.roomKtx)

    // Coroutines
    implementation (Dependencies.Coroutines.kotlinxCoroutines)

    //Viewpager Implementation
    implementation ("androidx.viewpager2:viewpager2:1.0.0")

    //CircleIndicator
    implementation ("me.relex:circleindicator:2.1.6")

    //glide dependency
    implementation ("com.github.bumptech.glide:glide:4.13.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.2")

    // Networking
    val retrofit_version = "2.9.0"
    val okhttp_version = "4.7.2"
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.okhttp3:okhttp:$okhttp_version")
    implementation ("com.squareup.okhttp3:logging-interceptor:$okhttp_version")

    // Dagger-Hilt
    implementation (Dependencies.DaggerHilt.daggerHiltAndroid)
    kapt (Dependencies.DaggerHilt.daggerHiltCompiler)

    //CoreUI module
    implementation(project(":core_ui"))

    //Core module
    implementation(project(":core"))

    //Domain
    implementation(project(":domain"))

    //Data
    implementation(project(":data"))


}