plugins {
    androidComLibrary
    androidLibrary
    kaptPlugin
    daggerHilt
    kotlinParcelize
}


android {
    namespace = "com.dapo.database"
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        testInstrumentationRunner = Application.testInstrumentationRunner
    }

    compileOptions {
        targetCompatibility = Java.javaVersion
        sourceCompatibility = Java.javaVersion
    }

    kotlinOptions {
        jvmTarget = Java.javaVersion.toString()
    }
}


dependencies {
    implementation(project(BuildModule.REMOTE))
    implementAll(Dependencies.databaseImplementation)
    testImplementAll(TestDependencies.cacheTestImplementation)
    testAndroidImplementAll(AndroidTestDependencies.cacheTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)

    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.0") {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}