plugins {
    id("android.data.convention")
}

android {
    namespace = "com.juhyeon.composemvi.data.local"
}

dependencies {
    implementation(projects.data.mapper)

    ksp(libs.room.compiler)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
}