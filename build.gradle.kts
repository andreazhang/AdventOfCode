plugins {
    kotlin("jvm") version "2.0.21"
    id("com.diffplug.spotless") version "7.0.0.BETA4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}

configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
        ktfmt()
        ktlint()
        diktat()
        prettier()
    }
    kotlinGradle {
        target("*.gradle.kts")
        ktlint()
    }
}
