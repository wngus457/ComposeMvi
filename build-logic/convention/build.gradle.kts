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
            id = "composemvi.android.application"
            implementationClass = "com.juhyeon.composemvi.convention.AndroidApplicationConventionPlugin"
        }
        register("AndroidLibraryPlugin") {
            id = "composemvi.android.library"
            implementationClass = "com.juhyeon.composemvi.convention.AndroidLibraryConventionPlugin"
        }
        register("FeaturePlugin") {
            id = "composemvi.android.feature"
            implementationClass = "com.juhyeon.composemvi.convention.FeatureConventionPlugin"
        }
        register("KotlinPlugin") {
            id = "composemvi.kotlin"
            implementationClass = "com.juhyeon.composemvi.convention.KotlinConventionPlugin"
        }
    }
}