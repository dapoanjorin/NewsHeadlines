object AndroidTestDependencies {
    private const val androidxTestExt = "androidx.test.ext:junit-ktx:${Versions.androidxTestExt}"
    private const val androidxTestCore = "androidx.test:core:${Versions.androidxTestCore}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    private const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
    private const val mockK = "io.mockk:mockk-android:${Versions.mockK}"
    private const val kotlinxCoroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutineVersion}"
    private const val androidXcore = "androidx.arch.core:core-testing:${Versions.androidXcore}"
    private const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}"
    private const val espressoContrib =
        "androidx.test.espresso:espresso-contrib:${Versions.espressoContrib}"
    private const val okHttpMockServer =
        "com.squareup.okhttp3:mockwebserver:${Versions.okHttpMockServer}"
    private const val jUnit = "androidx.test.ext:junit:1.1.3"

    object Compose {

        const val composeJunitTest = "androidx.compose.ui:ui-test-junit4:1.1.0"
    }

    val androidTestImplementation =
        listOf(
            androidxTestCore,
            androidxTestExt,
            espressoCore,
            googleTruth,
            mockK,
            kotlinxCoroutine,
            androidXcore,
            hiltTesting,
            espressoContrib,
            okHttpMockServer,
            jUnit,
            Compose.composeJunitTest
        )

    val remoteTestImplementation = listOf(
        googleTruth,
        mockK,
        kotlinxCoroutine,
        hiltTesting,
        jUnit,
        okHttpMockServer,
    )

    val cacheTestImplementation = listOf(
        androidxTestExt,
        espressoCore,
        googleTruth,
        mockK,
        jUnit,
        hiltTesting,
    )
}
