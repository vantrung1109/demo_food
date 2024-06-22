plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.appfood"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appfood"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField ("String", "BASE_URL", "\"https://ww-user-api.developteam.net/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

}

dependencies {

    //FlexboxLayout
    implementation ("com.google.android.flexbox:flexbox:3.0.0")

    //FlexibleAdapter
    implementation ("com.github.ddB0515.FlexibleAdapter:flexible-adapter:5.1.1")
    implementation("com.github.ddB0515.FlexibleAdapter:flexible-adapter-databinding:5.1.1")
    implementation("com.github.ddB0515.FlexibleAdapter:flexible-adapter-ui:5.1.1")
    implementation("com.github.ddB0515.FlexibleAdapter:flexible-adapter-livedata:5.1.1")
    implementation ("com.github.davideas:FlipView:1.2.0")

    // lombok
    compileOnly ("org.projectlombok:lombok:1.18.32")
    annotationProcessor ("org.projectlombok:lombok:1.18.32")

    // Unit sdp ssp
    implementation ("com.intuit.sdp:sdp-android:1.1.1")
    implementation ("com.intuit.ssp:ssp-android:1.1.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    //RxAndroid, Rxjava
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.8")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //Dagger 2
    implementation ("com.google.dagger:dagger:2.51.1")
    annotationProcessor ("com.google.dagger:dagger-compiler:2.51.1")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.3.1")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata:2.3.1")

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}