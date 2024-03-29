rootProject.name = "Multiplatform Example"

include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }

    plugins {
        val kotlinVersion = "1.9.22"
        val agpVersion = "8.2.2"
        val composeVersion = "1.6.0-rc01"
        val licencesVersion = "10.10.0"
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
