pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "Headline News"
include(":app")
include(":core")
include(":data")
include(":database")
include(":remote")
