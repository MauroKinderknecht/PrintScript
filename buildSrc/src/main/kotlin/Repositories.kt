import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.kotlin.dsl.maven

internal fun Project.configureRepositories() {
    val repositoryHandler = project.repositories
    repositoryHandler.mavenCentral()
    repositoryHandler.maven("https://maven.pkg.github.com/austral-ingsis/printscript-parser-common") {
        name = "GithubPackages"
        credentials.username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
        credentials.password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
    }
}
