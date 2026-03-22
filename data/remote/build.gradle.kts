plugins {
    id("android.data.convention")
}

android {
    namespace = "com.juhyeon.composemvi.data.remote"
}

dependencies {
    implementation(projects.data.mapper)
    implementation(projects.shared.util.common)

    implementation(libs.bundles.retrofit)
}