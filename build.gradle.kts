plugins {
    id("com.android.application") version "8.1.0" apply false
    kotlin("android") version "1.8.21" apply false
    kotlin("kapt") version "1.8.21" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
