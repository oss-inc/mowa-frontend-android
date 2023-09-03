import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

fun getProperties(key: String): String {
    return gradleLocalProperties(rootDir).getProperty(key)
}

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.inc.mowa"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.inc.mowa"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "SERVER_BASE_URL", getProperties("server.base.url"))
        buildConfigField("String", "OPEN_WEATHER_BASE_URL", getProperties("open.weather.base.url"))
        buildConfigField("String", "OPEN_WEATHER_API_KEY", getProperties("open.weather.api.key"))
        buildConfigField("String", "WELFARE_CENTER_BASE_URL", getProperties("welfare.center.base.url"))
        buildConfigField("String", "WELFARE_CENTER_API_KEY", getProperties("welfare.center.api.key"))
        buildConfigField("String", "KAKAO_MAP_API_KEY", getProperties("kakao.map.api.key"))

        manifestPlaceholders["KAKAO_MAP_API_KEY"] = getProperties("kakao.map.api.key")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // navigation bar
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    // recylcerview
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // drawerlayout
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // tablayout
    implementation("com.google.android.material:material:1.9.0")

    // retrofit for rest api
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // okhttp for rest api
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // indicator
    implementation("com.tbuonomo:dotsindicator:5.0")

    // gson
    implementation("com.google.code.gson:gson:2.10.1")

    // coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // location
    implementation("com.google.android.gms:play-services-location:21.0.0")

    // view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
}