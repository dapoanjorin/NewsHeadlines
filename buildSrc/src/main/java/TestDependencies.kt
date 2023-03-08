object TestDependencies {

    private const val junit4 = "junit:junit:${Versions.junit4Version}"
    private const val hamcrest = "org.hamcrest:hamcrest-all:${Versions.hamcrest}"
    private const val roboElectric = "org.robolectric:robolectric:${Versions.roboElectric}"
    private const val kotlinxCouroutine =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutineVersion}"
    private const val kotlinxCouroutineDebug =
        "org.jetbrains.kotlinx:kotlinx-coroutines-debug:${Versions.kotlinCoroutineVersion}"
    private const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
    private const val mockK = "io.mockk:mockk:${Versions.mockK}"
    private const val mockKJvm = "io.mockk:mockk-agent-jvm:${Versions.mockK}"
    private const val androidXcore = "androidx.arch.core:core-testing:${Versions.androidXcore}"
    private const val okHttpMockServer =
        "com.squareup.okhttp3:mockwebserver:${Versions.okHttpMockServer}"

    val testImplementation =
        listOf(
            junit4,
            hamcrest,
            roboElectric,
            kotlinxCouroutine,
            googleTruth,
            mockK,
            mockKJvm,
            androidXcore,
            okHttpMockServer,
        )

    val remoteTestImplementation = listOf(
        junit4,
        kotlinxCouroutine,
        googleTruth,
        mockK,
        mockKJvm,
        okHttpMockServer
    )

    val cacheTestImplementation = listOf(
        junit4,
        kotlinxCouroutineDebug,
        googleTruth,
        mockKJvm,
        mockK,
    )

    val domainTestImplementation = listOf(
        junit4,
        kotlinxCouroutine,
        googleTruth,
        mockK,
        mockKJvm,
    )
}
