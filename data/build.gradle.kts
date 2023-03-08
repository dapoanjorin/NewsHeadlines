plugins {
    androidComLibrary
    androidLibrary
    kaptPlugin
    hiltAndroid
}

android {
    namespace = "com.dapo.data"

    compileSdk = Versions.compileSdk
    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }
}

dependencies {
    implementation(project(BuildModule.DATABASE))
    implementation(project(BuildModule.REMOTE))
    implementAll(Dependencies.dataImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
}