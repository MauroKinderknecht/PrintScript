# PrintScript

## Get started

Create a `gradle.properties` file containing:
 ```
kotlin.code.style=official
gpr.user=<your_github_user>
gpr.key =<your_github_token>
 ```

TODO add to buildSrc
```
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.tasks.*

plugins {
    id("org.jmailen.kotlinter") version "3.9.0" apply false
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

tasks.withType<GradleBuild> {
    dependsOn("ktFormat")
    dependsOn("ktLint")
}
```