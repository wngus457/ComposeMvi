pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "ComposeMvi"
include(":app")
include(":shared:core-mvi")
include(":domain")
include(":data:local")
include(":data:remote")
include(":shared:util:common")
include(":data:mapper")
include(":shared:navigation")
include(":feature:splash")
include(":feature:home")
