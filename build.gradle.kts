plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    application
    java
    `java-library`
    `maven-publish`
    signing
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.jfrog.bintray") version "1.8.5"
    id("org.jlleitschuh.gradle.ktlint-idea") version "9.4.1"
    id("org.jetbrains.dokka") version "1.4.30"
    id("org.danilopianini.publish-on-central") version "0.4.0"
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/arrow-kt/arrow-kt/") }
    maven { url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local/") } // for SNAPSHOT builds
}

//  Project config
group = "com.mazekine"
version = "0.0.10-alpha"

//  Publishing config
val artifactName = "broxus-nova-lib"
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val artifactDescription = "Kotlin wrapper for Broxus Nova"

val pomUrl = "https://github.com/mazekine/nova-lib"
val pomScmUrl = "git:git@github.com:mazekine/nova-lib"
val pomIssueUrl = "https://github.com/mazekine/nova-lib/issues"
val pomDesc = "https://github.com/mazekine/nova-lib"

val githubRepoAddress = "mazekine/nova-lib"
val githubReadme = "README.md"

val pomLicenseName = "Apache-2.0"
val pomLicenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"
val pomLicenseDist = "repo"

val pomDeveloperId = "mazekine"
val pomDeveloperName = "Mazekine"
val pomDeveloperEmail = "hello@mazekine.com"


//  Arrow config
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
    kotlinOptions.jvmTarget = "11" // was 1.8
}.forEach {
    it.kotlinOptions { freeCompilerArgs = listOf("-Xnew-inference") }
}

application {
    mainClassName =
        "com.mazekine.nova.client.NovaApiService"    //  Have to leave it here until shadowJar fixes the compatibility bug
    mainClass.set("com.mazekine.nova.client.NovaApiService")
}

publishOnCentral {
    projectDescription = artifactDescription
    projectLongName = project.name
    licenseName = pomLicenseName
    licenseUrl = pomLicenseUrl
    projectUrl = pomUrl
    scmConnection = pomScmUrl

    repository("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/") {
        user = System.getenv("MAVEN_CENTRAL_USERNAME") ?: project.properties["mavenCentralUsername"].toString()
        password = System.getenv("MAVEN_CENTRAL_PASSWORD") ?: project.properties["mavenCentralPassword"].toString()
        name = "Sonatype"
    }

    publishing {
        publications {
            withType<MavenPublication> {
                configurePomForMavenCentral()
            }
        }
    }
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                developers {
                    developer {
                        name.set(pomDeveloperName)
                        email.set(pomDeveloperEmail)
                        url.set(pomUrl)
                    }
                }
            }
        }
    }
}