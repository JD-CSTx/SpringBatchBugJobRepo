repositories {
    gradlePluginPortal()
    mavenLocal()
    mavenCentral()
    maven(url = "https://repo.spring.io/milestone")
}

plugins {
    java
    id("org.springframework.boot") version "3.0.0-RC1"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

group "org.example"
version "1.0-SNAPSHOT"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch:3.0.0-RC1")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client:3.0.7")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
}