plugins {
    id("android.library.convention")
    alias(libs.plugins.serialization)
}

android {
    namespace = "com.juhyeon.composemvi.shared.util.common"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.shared.coreMvi)

    implementation(libs.java.inject)
    implementation(libs.serialization)
}