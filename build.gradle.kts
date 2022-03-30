import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.tasks.*

plugins {
    kotlin("jvm") version "1.6.10"
    application
    id("org.jmailen.kotlinter") version "3.9.0" apply false
}

group = "me.maurokinderknecht"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven {
        name = "GitHubPackages"
        url = uri("https://maven.pkg.github.com/austral-ingsis/printscript-parser-common")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.austral.ingsis.printscript:printscript-parser-common:0.1.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.register<LintTask>("ktLint") {
    group = "verification"
    source(files("src"))
    reports.set(
        mapOf(
            "plain" to file("build/lint-report.txt"),
            "json" to file("build/lint-report.json")
        )
    )
}

tasks.register<FormatTask>("ktFormat") {
    group = "formatting"
    source(files("src"))
    report.set(file("build/format-report.txt"))
}

tasks.withType<GradleBuild>{
    dependsOn("ktFormat")
    dependsOn("ktLint")
}

application {
    mainClass.set("MainKt")
}

