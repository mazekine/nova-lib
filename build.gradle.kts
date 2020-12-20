plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    application
    java
    `java-library`
    `maven-publish`
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.jfrog.bintray") version "1.8.5"
    id("org.jlleitschuh.gradle.ktlint-idea") version "9.4.1"
}

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://dl.bintray.com/arrow-kt/arrow-kt/") }
    maven { url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local/") } // for SNAPSHOT builds
}

//  Project config
group = "com.broxus"
version = "0.0.3-alpha"

//  Bintray config
val artifactName = "nova-lib"
val artifactGroup = project.group.toString()
val artifactVersion = project.version.toString()

val pomUrl = "https://github.com/vp-mazekine/nova-lib"
val pomScmUrl = "https://github.com/vp-mazekine/nova-lib"
val pomIssueUrl = "https://github.com/vp-mazekine/nova-lib/issues"
val pomDesc = "https://github.com/vp-mazekine/nova-lib"

val githubRepoAddress = "vp-mazekine/nova-lib"
val githubReadme = "README.md"

val pomLicenseName = "Apache-2.0"
val pomLicenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"
val pomLicenseDist = "repo"

val pomDeveloperId = "vp-mazekine"
val pomDeveloperName = "Vladislav Ponomarev"
val pomDeveloperEmail = "vp@mazekine.com"


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
    mainClassName = "com.broxus.nova.client.NovaApiService"    //  Have to leave it here until shadowJar fixes the compatibility bug
    mainClass.set("com.broxus.nova.client.NovaApiService")
}

val sourcesJar by tasks.creating(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.getByName("main").allSource)
}

publishing {
    publications {
        create<MavenPublication>(artifactName) {
            groupId = artifactGroup
            artifactId = artifactName
            version = artifactVersion
            from(components["java"])

            artifact(sourcesJar)

            pom.withXml{
                asNode().apply {
                    appendNode("description", pomDesc)
                    appendNode("name", rootProject.name)
                    appendNode("url", pomUrl)
                    appendNode("licenses").appendNode("license").apply {
                        appendNode("name", pomLicenseName)
                        appendNode("url", pomLicenseUrl)
                        appendNode("distribution", pomLicenseDist)
                    }
                    appendNode("developers").appendNode("developer").apply {
                        appendNode("id", pomDeveloperId)
                        appendNode("name", pomDeveloperName)
                        appendNode("email", pomDeveloperEmail)
                    }
                    appendNode("scm").apply {
                        appendNode("url", pomScmUrl)
                    }
                }
            }
        }
    }
}

bintray {
    user = project.findProperty("bintrayUser").toString()
    key = project.findProperty("bintrayKey").toString()
    setPublications(artifactName)

    dryRun = false
    publish = true
    override = false

    pkg(delegateClosureOf<com.jfrog.bintray.gradle.BintrayExtension.PackageConfig>{
        repo = artifactName
        name = artifactName

        userOrg = "cryonyx"
        githubRepo = githubRepoAddress
        vcsUrl = pomUrl
        description = "Kotlin wrapper for Broxus Nova API"
        desc = description
        websiteUrl = pomUrl
        issueTrackerUrl = pomIssueUrl
        githubReleaseNotesFile = githubReadme

        setLabels("kotlin", "broxus", "nova", "wrapper", "mazekine")
        setLicenses("Apached-2.0")

        version(delegateClosureOf<com.jfrog.bintray.gradle.BintrayExtension.VersionConfig> {
            name = artifactVersion
            desc = pomDesc
            vcsTag = artifactVersion
        })
    })
}