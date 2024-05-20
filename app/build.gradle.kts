import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.luisdev.tvphotosapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.luisdev.tvphotosapp"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }

        val file = project.rootProject.file("dev.properties")
        val properties = Properties()
        properties.load(file.inputStream())

        //return empty key in case something goes wrong
        val clientKey = properties.getProperty("CLIENT_ID") ?: ""
        val baseUrl = properties.getProperty("BASE_URL") ?: ""

        buildConfigField(
            type = "String",
            name = "CLIENT_ID",
            value = clientKey
        )
        buildConfigField(
            type = "String",
            name = "BASE_URL",
            value = baseUrl
        )

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
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.tv:tv-foundation:1.0.0-alpha10")
    implementation("androidx.tv:tv-material:1.0.0-beta01")

    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("com.google.android.material:material:1.12.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("androidx.compose.runtime:runtime-livedata:1.6.7")


    // JSON parser
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")


    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    // GLIDE images
    implementation ("com.github.bumptech.glide:compose:1.0.0-beta01")

    // Hilt for dependency injection
    implementation ("com.google.dagger:hilt-android:2.46.1")
    kapt ("com.google.dagger:hilt-compiler:2.46.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")


    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
}