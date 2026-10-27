plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
val runNumber = (System.getenv("GITHUB_RUN_NUMBER") ?: "1").toInt()
android {
    namespace = "de.denkpause.app"
    compileSdk = 34
    defaultConfig {
        applicationId = "de.denkpause.app"
        minSdk = 21
        targetSdk = 34
        versionCode = runNumber
        versionName = "1.$runNumber"
    }
    signingConfigs {
        create("release") {
            storeFile = file("release.keystore")
            storePassword = "denkpause42"
            keyAlias = "denkpause"
            keyPassword = "denkpause42"
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.webkit:webkit:1.11.0")
}
