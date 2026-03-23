plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.agp)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ksp)
    compileOnly(libs.compose.compiler.extension)
}

gradlePlugin {
    plugins {
        register("AndroidApplicationPlugin") {
            id = "android.app.convention"
            implementationClass = "com.juhyeon.composemvi.convention.AndroidApplicationConventionPlugin"
        }
        register("SharedLibraryPlugin") {
            id = "android.library.convention"
            implementationClass = "com.juhyeon.composemvi.convention.SharedLibraryConventionPlugin"
        }
        register("FeaturePlugin") {
            id = "android.feature.convention"
            implementationClass = "com.juhyeon.composemvi.convention.FeatureConventionPlugin"
        }
        register("KotlinPlugin") {
            id = "android.kotlin.convention"
            implementationClass = "com.juhyeon.composemvi.convention.KotlinConventionPlugin"
        }
        register("DataPlugin") {
            id = "android.data.convention"
            implementationClass = "com.juhyeon.composemvi.convention.DataConventionPlugin"
        }
        register("DomainPlugin") {
            id = "android.domain.convention"
            implementationClass = "com.juhyeon.composemvi.convention.DomainConventionPlugin"
        }
    }
}