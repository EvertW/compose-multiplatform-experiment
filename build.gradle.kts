plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    kotlin("multiplatform").apply(false)
    kotlin("plugin.serialization").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
    id("com.mikepenz.aboutlibraries.plugin").apply(false)
    id("dev.icerock.mobile.multiplatform-resources").apply(false)
}

buildscript {
    repositories {
        gradlePluginPortal()
    }

    dependencies {
        classpath("dev.icerock.moko:resources-generator:0.23.0")
    }
}
