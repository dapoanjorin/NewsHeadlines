plugins {
    androidApplication
    androidLibrary
    kaptPlugin
    daggerHilt
    navigationSafeArgsKotlin
    kotlinParcelize
}


android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = Application.id
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Application.versionCode
        versionName = Application.versionName
        testInstrumentationRunner = Application.testInstrumentationRunner
    }

    buildFeatures {
        compose = true
    }

    buildTypes {

        release {

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        targetCompatibility = Java.javaVersion
        sourceCompatibility = Java.javaVersion

    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }

    kotlinOptions {
        jvmTarget = Java.javaVersion.toString()
    }
}


dependencies {

    implementation(project(BuildModule.DATA))
    implementation(project(BuildModule.CORE))
    implementation(project(BuildModule.REMOTE))
    implementAll(Dependencies.implementations)
    testImplementAll(TestDependencies.testImplementation)
    testAndroidImplementAll(AndroidTestDependencies.androidTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    debugImplementationAll(DebugDependencies.debugImplementation)

}