plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ilya.rm"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ilya.rm"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation (libs.androidx.core.ktx.v1101)

    // Compose
    implementation (libs.ui)
    implementation (libs.material3)
    implementation (libs.ui.tooling.preview)
    debugImplementation (libs.ui.tooling)

    // Navigation Compose
    implementation (libs.androidx.navigation.compose)

    // Retrofit + Gson
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    // OkHttp logging interceptor
    implementation (libs.logging.interceptor)

    // Coil for image loading
    implementation (libs.coil.compose)

    // Koin DI
    implementation (libs.koin.android)
    implementation (libs.koin.androidx.compose)

    // Lifecycle ViewModel Compose
    implementation (libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.koin.android.v340)
    implementation(libs.koin.androidx.compose)
    implementation (libs.androidx.material3.v110alpha01)
    implementation (libs.material3)
}