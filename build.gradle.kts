import io.ktor.plugin.features.javaVersion

val exposed_version: String by project
val h2_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.1.0"
    id("io.ktor.plugin") version "3.1.1"
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.0"
    application
}

group = "ir.amirreza"
version = "0.0.1"


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

application {
    mainClass = "ir.amirreza.ApplicationKt"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposed_version")
    implementation("com.h2database:h2:$h2_version")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    // Auth
    implementation("io.ktor:ktor-server-auth")

    // KtorAdmin library
    val ktorAdmin = "0.0.1-alpha8"
    implementation("io.github.amirroid:KtorAdmin:$ktorAdmin")
    ksp("io.github.amirroid:KtorAdmin:$ktorAdmin")

    // Postgres
    implementation("org.postgresql:postgresql:42.7.4")

    // BCrypt
    implementation("at.favre.lib:bcrypt:0.10.2")
}

//tasks.withType<Jar> {
//    manifest {
//        attributes["Main-Class"] = "ir.amirreza.ApplicationKt"
//    }
//    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
//}
ktor {
    fatJar {
        archiveFileName.set("ktor-app.jar")
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "ir.amirreza.ApplicationKt"
    }
}