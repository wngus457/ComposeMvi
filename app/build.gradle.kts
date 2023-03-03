plugins {
    id(Plugins.androidApplication)
    id(Plugins.android)
    id(Plugins.hiltAndroid)
    id(Plugins.kotlinKapt)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(platform(Compose.bom))
    implementation(Compose.ui)
    implementation(Compose.tooling)
    implementation(Compose.toolingPreview)
    implementation(Compose.material)
    implementation(Compose.material3)
    implementation(Compose.icon)
    implementation(Compose.hiltNavigation)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltAndroidCompiler)
}