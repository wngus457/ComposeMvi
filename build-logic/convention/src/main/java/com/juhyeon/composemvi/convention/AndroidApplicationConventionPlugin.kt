package com.juhyeon.composemvi.convention

import com.android.build.api.dsl.ApplicationExtension
import com.juhyeon.composemvi.convention.config.AppConfig
import com.juhyeon.composemvi.convention.config.composeCompiler
import com.juhyeon.composemvi.convention.config.configureCommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("dagger.hilt.android.plugin")
                apply("com.google.devtools.ksp")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                namespace = AppConfig.applicationId
                configureCommonExtension(this)

                defaultConfig {
                    applicationId = AppConfig.applicationId
                    versionCode = AppConfig.versionCode
                    versionName = AppConfig.versionName
                    targetSdk = 35
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    vectorDrawables.useSupportLibrary = true
                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        isShrinkResources = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }

                    debug {
                        isDebuggable = true
                    }
                }

                buildFeatures {
                    compose = true
                    buildConfig = true
                }

                composeCompiler {
                    includeSourceInformation.set(true)
                }

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }

                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

                dependencies {
                    add("implementation", project(":shared:core-mvi"))
                    add("implementation", project(":shared:util:common"))
                    add("implementation", project(":shared:navigation"))

                    add("implementation", project(":domain"))

                    add("implementation", project(":data:remote"))
                    add("implementation", project(":data:local"))
                    add("implementation", project(":data:mapper"))

                    add("implementation", project(":feature:splash"))
                    add("implementation", project(":feature:home"))


                    add("implementation", platform(libs.findLibrary("compose-bom").get()))
                    add("implementation", libs.findBundle("compose").get())
                    add("implementation", libs.findLibrary("compose-navigation").get())

                    add("implementation", libs.findLibrary("accompainst-system-ui").get())

                    add("implementation", libs.findBundle("retrofit").get())

                    add("implementation", libs.findLibrary("hilt-android").get())
                    add("ksp", libs.findLibrary("hilt-android-compiler").get())

                    add("implementation", libs.findLibrary("room-runtime").get())
                    add("implementation", libs.findLibrary("room-ktx").get())
                    add("ksp", libs.findLibrary("room-compiler").get())

                    add("implementation", libs.findLibrary("serialization").get())
                }
            }
        }
    }
}