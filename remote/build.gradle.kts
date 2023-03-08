plugins {
    androidComLibrary
    androidLibrary
    kaptPlugin
    daggerHilt
    kotlinParcelize
    secretsGradlePlugin
}

android {

    namespace = "com.dapo.remote"

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

secrets {
    // Change the properties file from the default "local.properties" in your root project
    // to another properties file in your root project.
    propertiesFileName = "secrets.properties"

    // A properties file containing default secret values. This file can be checked in version
    // control.
    defaultPropertiesFileName = "secrets.defaults.properties"

    // Configure which keys should be ignored by the plugin by providing regular expressions.
    // "sdk.dir" is ignored by default.
    ignoreList.add("keyToIgnore") // Ignore the key "keyToIgnore"
    ignoreList.add("sdk.*")       // Ignore all keys matching the regexp "sdk.*"
}

dependencies {
    implementAll(Dependencies.remoteImplementation)
    testImplementAll(TestDependencies.remoteTestImplementation)
    testAndroidImplementAll(AndroidTestDependencies.remoteTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
}