plugins {
    id("android.data.convention")
}
android {
    namespace = "com.juhyeon.composemvi.data.mapper"
}

dependencies {
    implementation(projects.domain)
}