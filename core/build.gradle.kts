plugins {
    androidComLibrary
    androidLibrary
    kaptPlugin
    daggerHilt
    kotlinParcelize
}

android {
    namespace = "com.dapo.core"

    compileSdk = Versions.compileSdk


}

dependencies {
    implementation(project(BuildModule.DATABASE))
    implementation(project(BuildModule.DATA))
    implementation(project(BuildModule.REMOTE))
    implementAll(Dependencies.coreImplementations)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)

}