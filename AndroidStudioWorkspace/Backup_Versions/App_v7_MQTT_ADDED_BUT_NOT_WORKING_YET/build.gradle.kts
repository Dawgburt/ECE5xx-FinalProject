plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //kotlin("kapt") // This enables the Kotlin annotation processor (Used for Room DB, left commented for ease trying to integrate in the future)
}

android {
    namespace = "ece5xx.joint.project.app_Nick_A_Phil_N"
    compileSdk = 35

    defaultConfig {
        applicationId = "ece5xx.joint.project.app_Nick_A_Phil_N"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.compose.material:material-icons-extended:1.0.0") //for visibility icons
    implementation("androidx.navigation:navigation-compose:2.4.2") //For navigation
    implementation("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5") //paho mqtt

    //implementation("com.hivemq:hivemq-mqtt-client:1.3.0") //For MQTT hivemq

    /*
    //If attempting to utilize ROOM DB:

    val room_version = "2.5.0" // Use the latest version of Room

    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")


    //If attempting REALM DB:
    implementation("io.realm.kotlin:library-base:1.11.0") // Use the latest version

    * */

}