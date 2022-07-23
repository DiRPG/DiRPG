import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.serialization") version "1.7.10"
}

group = "org.github.dirpg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // kotlinx-serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.3")

    // kotlinx-cli
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}