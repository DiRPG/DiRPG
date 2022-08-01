import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    id("application")
}

group = "org.github.dirpg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
}

dependencies {
    testImplementation(kotlin("test"))

    // kotlinx-serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    // kotlinx-cli
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")

    // kord-extensions
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")

    // slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.0-alpha7")

    // kmongo
    implementation("org.litote.kmongo:kmongo:4.6.1")
}

application {
    mainClass.set("EntryKt")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}