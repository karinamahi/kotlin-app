plugins {
    kotlin("jvm") version "1.9.20"
    application
    kotlin("plugin.spring") version "1.9.20"
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.flywaydb.flyway") version "11.4.0"
}

buildscript {
    dependencies {
        classpath("org.postgresql:postgresql:42.7.3")
        classpath("org.flywaydb:flyway-database-postgresql:10.20.1")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(enforcedPlatform("org.apache.camel.springboot:camel-spring-boot-bom:4.11.0"))
    implementation("org.apache.camel.springboot:camel-spring-boot-starter")
    implementation("org.postgresql:postgresql:42.7.3")
    implementation("org.flywaydb:flyway-database-postgresql")
    implementation("org.flywaydb:flyway-core")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:junit-jupiter")
}

application {
    mainClass.set("com.example.ApplicationKt")
}

flyway {
    url="jdbc:postgresql://localhost:5432/kotlin-app"
    user="postgres"
    schemas= arrayOf("public")
    locations= arrayOf("classpath:db/migration")
}

tasks.withType<Test> {
    useJUnitPlatform()
}