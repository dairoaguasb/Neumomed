private object TestLibraryVersion {
    const val ANDROIDX_TEST = "1.1.1"
    const val ESPRESSO_CORE = "3.2.0-alpha02"
    const val ARCH_CORE_TEST = "2.0.0"
    const val JUNIT = "4.12"
    const val ANDROID_JUNIT = "1.1.0"
    const val FRAGMENT_TEST = "1.1.0-alpha06"
    const val MOCK_WEB_SERVER = "2.7.5"
    const val MOCKK = "1.9.2"
    const val DATA_BINDING = "3.3.2"
    const val MOCKITO = "3.0.0"
    const val MOCKITO_KOTLIN = "2.1.0"
    const val KLUENT = "1.55"
}

object TestLibraries {
    val JUNIT = "junit:junit:${TestLibraryVersion.JUNIT}"
    // ANDROID TEST
    val ANDROID_TEST_RULES = "androidx.test:rules:${TestLibraryVersion.ANDROIDX_TEST}"
    val ANDROID_TEST_RUNNER = "androidx.test:runner:${TestLibraryVersion.ANDROIDX_TEST}"
    val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${TestLibraryVersion.ESPRESSO_CORE}"
    val ESPRESSO_CONTRIB = "androidx.test.espresso:espresso-contrib:${TestLibraryVersion.ESPRESSO_CORE}"
    val ARCH_CORE_TEST = "androidx.arch.core:core-testing:${TestLibraryVersion.ARCH_CORE_TEST}"
    val ANDROID_JUNIT = "androidx.test.ext:junit:${TestLibraryVersion.ANDROID_JUNIT}"
    val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${TestLibraryVersion.FRAGMENT_TEST}"
    // KOIN
    val KOIN_TEST = "org.koin:koin-test:${LibraryVersion.KOIN}"
    // MOCK WEBSERVER
    val MOCK_WEB_SERVER = "com.squareup.okhttp:mockwebserver:${TestLibraryVersion.MOCK_WEB_SERVER}"
    // MOCK
    val MOCKK_ANDROID = "io.mockk:mockk-android:${TestLibraryVersion.MOCKK}"
    val MOCKK = "io.mockk:mockk:${TestLibraryVersion.MOCKK}"
    // COROUTINE
    val COROUTINE = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${LibraryVersion.COROUTINES}"
    // DATA BINDING
    val DATA_BINDING = "androidx.databinding:databinding-compiler:${TestLibraryVersion.DATA_BINDING}"
    // MOCKITO
    val MOCKITO_INLINE = "org.mockito:mockito-inline:${TestLibraryVersion.MOCKITO}"
    val MOCKITO_ANDROID = "org.mockito:mockito-android:${TestLibraryVersion.MOCKITO}"
    val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${TestLibraryVersion.MOCKITO_KOTLIN}"
    //KLUENT
    val KLUENT_ANDROID = "org.amshove.kluent:kluent-android:${TestLibraryVersion.KLUENT}"
    val KLUENT = "org.amshove.kluent:kluent:${TestLibraryVersion.KLUENT}"
}
