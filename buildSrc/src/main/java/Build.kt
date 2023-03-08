object Build {
    private const val buildTools = "com.android.tools.build:gradle:${Versions.gradle}"
    private const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    private const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafeArgs}"
    private const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    private const val secretGradlePluin =
        "com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.gradleSecrets}"

    val classPaths =
        listOf(buildTools, kotlinGradlePlugin, navigationSafeArgs, hiltAndroidGradlePlugin, secretGradlePluin)
}