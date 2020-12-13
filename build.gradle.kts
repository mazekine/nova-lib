plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    application
    java
    `java-library`
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.broxus"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/arrow-kt/arrow-kt/") }
    maven { url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local/") } // for SNAPSHOT builds
}

val arrowVersion = "0.11.0"

dependencies {
    implementation(kotlin("stdlib"))

    //  System utils
    implementation("org.apache.commons:commons-lang3:3.11")

    //  Logging
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("ch.qos.logback:logback-core:1.2.3")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.0")

    //  Retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:2.3.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")

    //  Arrow dependencies
    implementation("io.arrow-kt:arrow-core:$arrowVersion")
    implementation("io.arrow-kt:arrow-syntax:$arrowVersion")
    kapt("io.arrow-kt:arrow-meta:$arrowVersion")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}.forEach {
    it.kotlinOptions { freeCompilerArgs = listOf("-Xnew-inference") }
}

application {
    mainClassName = "com.broxus.nova.client.NovaApiService"    //  Have to leave it here until shadowJar fixes the compatibility bug
    mainClass.set("com.broxus.nova.client.NovaApiService")
}

tasks.jar {
    archiveBaseName.set("nova-lib")
    archiveClassifier.set("")
    archiveExtension.set("jar")
}