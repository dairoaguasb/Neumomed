object LibraryVersion {
    const val APP_COMPACT = "1.1.0"
    const val COROUTINES = "1.3.3"
    const val CORE_KTX = "1.1.0"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val LIFECYCLE = "2.2.0"
    const val RECYCLER_VIEW = "1.0.0"
    const val NAVIGATION = "2.1.0"
    const val MATERIAL = "1.1.0"
    const val KOIN = "2.0.1"
    const val ROOM = "2.2.2"
    const val RETROFIT = "2.6.2"
    const val RETROFIT_COROUTINE = "0.9.2"
    const val MOSHI = "1.8.0"
    const val OKHTTP = "4.2.2"
    const val GLIDE = "4.9.0"
    const val TIMBER = "4.7.1"
    const val APP_INTRO = "5.1.0"
    const val VIEWPAGERDOT = "4.1.2"
    const val AUTO_IMAGE_SLIDER = "1.3.2"
    const val ANKO = "0.10.8"
    const val KRATE = "0.4.0"
    const val KOTLIN_COROUTINE_PLAY_SERVICE = "1.1.1"
    const val PHOTOVIEW = "2.3.0"
    const val MATERIAL_STYLED_DIALOG = "2.1"
    const val CIRCLE_IMAGE_VIEW = "3.1.0"
    const val EVENT_BUS = "3.2.0"
}

object Libraries {
    // KOIN
    val KOIN = "org.koin:koin-android:${LibraryVersion.KOIN}"
    val KOIN_VIEW_MODEL = "org.koin:koin-android-viewmodel:${LibraryVersion.KOIN}"
    val KOIN_SCOPE = "org.koin:koin-androidx-scope:${LibraryVersion.KOIN}"

    // ROOM
    val ROOM_COMPILER = "androidx.room:room-compiler:${LibraryVersion.ROOM}"
    val ROOM_RUNTIME = "androidx.room:room-runtime:${LibraryVersion.ROOM}"
    val ROOM_KTX = "androidx.room:room-ktx:${LibraryVersion.ROOM}"

    // RETROFIT Y MOSHI
    val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT}"
    val MOSHI = "com.squareup.moshi:moshi:${LibraryVersion.MOSHI}"
    val MOSHI_KOTLIN = "com.squareup.moshi:moshi-kotlin:${LibraryVersion.MOSHI}"
    val RETROFIT_MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${LibraryVersion.RETROFIT}"
    val RETROFIT_COROUTINE_ADAPTER = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${LibraryVersion.RETROFIT_COROUTINE}"
    val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.OKHTTP}"

    // GLIDE
    val GLIDE = "com.github.bumptech.glide:glide:${LibraryVersion.GLIDE}"

    //TIMBER
    val TIMBER = "com.jakewharton.timber:timber:${LibraryVersion.TIMBER}"

    //APPINTRO
    val APP_INTRO = "com.github.AppIntro:AppIntro:${LibraryVersion.APP_INTRO}"

    //VIEWPAGERDOT
    val VIEWPAGERDOT = "com.tbuonomo.andrui:viewpagerdotsindicator:${LibraryVersion.VIEWPAGERDOT}"

    //KRATE
    val KRATE = "hu.autsoft:krate:${LibraryVersion.KRATE}"

    val AUTO_IMAGE_SLIDER = "com.github.smarteist:autoimageslider:${LibraryVersion.AUTO_IMAGE_SLIDER}"

    //ANKO
    val ANKO = "org.jetbrains.anko:anko:${LibraryVersion.ANKO}"
    val ANKO_COMMONS = "org.jetbrains.anko:anko-commons:${LibraryVersion.ANKO}"
    val ANKO_DESING = "org.jetbrains.anko:anko-design:${LibraryVersion.ANKO}"

    //PHOTOVIEW
    val PHOTOVIEW = "com.github.chrisbanes:PhotoView:${LibraryVersion.PHOTOVIEW}"

    val MATERIAL_STYLED_DIALOG = "com.github.javiersantos:MaterialStyledDialogs:${LibraryVersion.MATERIAL_STYLED_DIALOG}"

    val CIRCLE_IMAGE_VIEW = "de.hdodenhof:circleimageview:${LibraryVersion.CIRCLE_IMAGE_VIEW}"

    val EVENT_BUS = "org.greenrobot:eventbus:${LibraryVersion.EVENT_BUS}"
}


object KotlinLibraries {
    val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${CoreVersion.KOTLIN}"
    val KOTLIN_COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${LibraryVersion.COROUTINES}"
    val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${LibraryVersion.COROUTINES}"
}

object AndroidLibraries {
    // ANDROID
    val APP_COMPACT = "androidx.appcompat:appcompat:${LibraryVersion.APP_COMPACT}"
    val CORE_KTX = "androidx.core:core-ktx:${LibraryVersion.CORE_KTX}"
    val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${LibraryVersion.CONSTRAINT_LAYOUT}"

    val LIFECYCLE_EXTENSIONS = "androidx.lifecycle:lifecycle-extensions:${LibraryVersion.LIFECYCLE}"
    val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${LibraryVersion.LIFECYCLE}"
    val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${LibraryVersion.LIFECYCLE}"

    val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${LibraryVersion.RECYCLER_VIEW}"
    val NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${LibraryVersion.NAVIGATION}"
    val NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${LibraryVersion.NAVIGATION}"
    val MATERIAL = "com.google.android.material:material:${LibraryVersion.MATERIAL}"
}