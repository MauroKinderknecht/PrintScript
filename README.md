# PrintScript

## Get started

Create a `gradle.properties` file containing:
 ```
kotlin.code.style=official
gpr.user=<your_github_user>
gpr.key =<your_github_token>
 ```

## Pre-commit
> If you dont see the .git folder, check this [link](https://stackoverflow.com/questions/35784352/intellij-doesnt-show-git-directory)

To add this functionality, we need to create the file pre-commit in ./git/hooks
- Paste the next code into that file
```
#!/bin/sh

echo "*****Running formatKotlin ******"

git stash -q --keep-index

./gradlew formatKotlin

status=$?
git stash pop -q

echo "*****Done with formatKotlin******"

exit $status
```
Then we need to execute the line below
```
chmod +x .git/hooks/pre-commit
```



TODO add to buildSrc
```
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jmailen.gradle.kotlinter.tasks.*

plugins {
    
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