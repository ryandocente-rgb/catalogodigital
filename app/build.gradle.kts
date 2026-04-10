plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.catalogodigital"
    compileSdk = 34 // Mude aqui (remova aquele bloco release { ... })

    defaultConfig {
        applicationId = "com.example.catalogodigital"
        minSdk = 24
        targetSdk = 34 // Mude aqui para 34
        versionCode = 1
        versionName = "1.0"
        // ... resto igual
    }

    // Mude a compatibilidade para Java 17 (é o padrão mais seguro hoje)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    // Note que cada hífen do arquivo TOML virou um ponto aqui
    implementation(libs.androidx.core.ktx)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}