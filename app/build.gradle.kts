plugins {
    kotlin("jvm") version "1.9.20"
    application
    kotlin("plugin.spring") version "1.9.20"
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(enforcedPlatform("org.apache.camel.springboot:camel-spring-boot-bom:4.11.0"))
    implementation("org.apache.camel.springboot:camel-spring-boot-starter")
}

application {
    mainClass.set("com.example.ApplicationKt")
}