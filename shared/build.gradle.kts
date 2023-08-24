plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.mikepenz.aboutlibraries.plugin")
    id("dev.icerock.mobile.multiplatform-resources")
}

kotlin {
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val voyagerVersion = "1.0.0-rc06"
        val ktorVersion = "2.3.0"

        val commonMain by getting {
            dependencies {
                api("androidx.datastore:datastore-preferences-core:1.1.0-alpha04")
                api("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
                api("cafe.adriel.voyager:voyager-bottom-sheet-navigator:$voyagerVersion")
                api("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
                api("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")
                api("cafe.adriel.voyager:voyager-kodein:$voyagerVersion")
                api("br.com.devsrsouza.compose.icons:tabler-icons:1.1.0")
                api("com.moriatsushi.insetsx:insetsx:0.1.0-alpha10")
                api("io.ktor:ktor-client-core:$ktorVersion")
                api("io.ktor:ktor-client-cio:$ktorVersion")
                api("io.ktor:ktor-client-logging:$ktorVersion")
                api("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                api("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                api("org.kodein.di:kodein-di:7.20.1")
                api("org.kodein.di:kodein-di-framework-compose:7.20.1")
                api("com.mikepenz:aboutlibraries-core:10.9.0-b01")
                api("com.mikepenz:aboutlibraries-compose:10.9.0-b01")
                api("dev.icerock.moko:resources:0.23.0")
                api("dev.icerock.moko:resources-compose:0.23.0")
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(compose.material3)
                api(compose.animation)
                api(compose.ui)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                api(compose.components.resources)
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            kotlin.srcDirs("src/jvmMain/kotlin")
            dependencies {
                api("androidx.activity:activity-compose:1.7.2")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")
                dependencies {
                    implementation("io.ktor:ktor-client-android:$ktorVersion")
                }
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.evertwoud.multiplatform.example"
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res", "src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(11)
    }
}

