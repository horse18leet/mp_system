plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization").version("1.9.10")

    kotlin("kapt")
    id("com.google.dagger.hilt.android")

    id("org.jetbrains.kotlin.plugin.lombok") version "1.5.20-RC"

}

android {
    namespace = "com.bytebusters.android.mpsystem"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bytebusters.android.mpsystem"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            //excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/*"
            excludes += "notice.txt"
            excludes += "license.txt"
        }
    }
}

val ktor_version: String by project
val logback_version: String by project
val junit_version: String by project
val hamcrest_version: String by project

dependencies {

    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.material:material:1.4.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.google.android.material:material:1.11.0")

    implementation("com.fasterxml.jackson.core:jackson-core:2.10.1")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.10.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.10.1")

    implementation("co.yml:ycharts:2.1.0")

    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.moshi:moshi:1.15.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.15.1")

    //ktor
//    implementation("io.ktor:ktor-client-core:$ktor_version")
//    implementation("io.ktor:ktor-client-cio:$ktor_version")
//    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-xml:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-cbor:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-protobuf:$ktor_version")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


    //implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("junit:junit:$junit_version")
    testImplementation("org.hamcrest:hamcrest:$hamcrest_version")

    //hilt
    implementation("com.google.dagger:hilt-android:2.44")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    kapt("com.google.dagger:hilt-compiler:2.44")

    // compose
    implementation("androidx.compose.material:material:1.0.2")
    implementation("androidx.compose.ui:ui:1.0.2")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview:1.0.2")
    implementation("androidx.compose.material:material-icons-extended:1.0.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.material3:material3")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02")
    implementation("androidx.activity:activity-compose:1.3.0")
    implementation("androidx.paging:paging-compose:1.0.0-alpha12")

    // coil
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("io.coil-kt:coil-compose:1.3.2")

    // base
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.21")
    implementation("androidx.startup:startup-runtime:1.1.0")

    //postgres
//    implementation("org.postgresql:postgresql:42.1.4")
//    runtimeOnly("org.postgresql:postgresql")
//
//    implementation("org.xerial:sqlite-jdbc:3.7.2")

    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")

    implementation("io.coil-kt:coil-compose:2.2.2")

    // View
    implementation("me.saket.cascade:cascade:2.0.0-rc01")
    // Jetpack Compose
    implementation("me.saket.cascade:cascade-compose:2.0.0-rc01")




    compileOnly("org.projectlombok:lombok:1.18.20")
    annotationProcessor("org.projectlombok:lombok:1.18.20")

    implementation("org.springframework.data:spring-data-jpa:2.6.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

kapt {
    correctErrorTypes = true

    arguments {
        arg("kotgres.db.qualifiedName", "my.pack.DB") // default database class name
        arg("kotgres.spring", "false") // marks database class as Spring's component
    }
}