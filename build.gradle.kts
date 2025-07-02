import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// Kotlin + Spring + JPA
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.jpa")    version "1.9.25"

	// Spring Boot / Dependency Management
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.7"

	id("org.flywaydb.flyway") version "9.22.0"

}

group = "com.github.diogenesssantos"
version = "0.0.1-SNAPSHOT"

// Java 21 via toolchain
java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(21))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Web + JSON
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// JPA / Hibernate / HikariCP
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("mysql:mysql-connector-java:8.0.33")

	//FlywayImplementacao
	implementation("org.flywaydb:flyway-mysql:10.10.0")
	implementation("org.flywaydb:flyway-core:10.10.0")


	// OpenAPI UI (Swagger)
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	// Testes
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// Só gera o fat-jar (disable do jar “plain”)
tasks.named<Jar>("jar") {
	enabled = false
}

// Configura o fat-jar do Spring Boot
tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	archiveFileName.set("api.jar")
	// aponte para sua classe main
	mainClass.set("com.github.diogenesssantos.mercadolivro.MercadolivroApplicationKt")
}

// Ajustes Kotlin
tasks.withType<KotlinCompile> {
	kotlinOptions {
		jvmTarget = "21"
		freeCompilerArgs = listOf("-Xjsr305=strict")
	}
}


tasks.test {
	useJUnitPlatform()
}
