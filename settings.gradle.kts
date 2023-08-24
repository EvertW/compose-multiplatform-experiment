rootProject.name = "MultiCompose"

include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    plugins {
        val kotlinVersion = "1.9.0"
        val agpVersion = "8.2.0-alpha16"
        val composeVersion = "1.5.0-beta02"
        val licencesVersion = "10.9.0-b01"
        val mokoVersion = "0.23.0"

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)
        kotlin("plugin.serialization").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)

        id("org.jetbrains.compose").version(composeVersion)
        id("com.mikepenz.aboutlibraries.plugin").version(licencesVersion)
        id("dev.icerock.mobile.multiplatform-resources").version(mokoVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
