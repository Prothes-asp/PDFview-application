plugins {
    id("com.android.application")
}

android {
    namespace = "com.aspprothes.sanatanshastra"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aspprothes.sanatanshastra"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "prothes 2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation("com.airbnb.android:lottie:3.4.0")
    implementation("com.makeramen:roundedimageview:2.3.0")
    implementation("com.github.fornewid:neumorphism:0.3.2")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.vimalcvs:Day-Night-Switch:1.0.3")
    implementation("com.github.mhiew:android-pdf-viewer:3.2.0-beta.3")

}