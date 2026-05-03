import org.gradle.kotlin.dsl.implementation

plugins {
    kotlin("jvm") version "2.2.20"
    id("org.springframework.boot") version "3.3.13"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.spring") version "2.2.20"
    kotlin("plugin.jpa") version "2.2.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
    // PostgreSQL
    implementation("org.postgresql:postgresql")

    // Liquibase
    implementation("org.liquibase:liquibase-core")

    // JobRunr
    implementation("org.jobrunr:jobrunr-spring-boot-3-starter:7.3.2")


}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
