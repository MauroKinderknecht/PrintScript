import org.gradle.api.Project
import org.gradle.api.Plugin

open class PrintScriptPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configureRepositories()
        project.configurePlugins()
        project.configureDependencies()
    }
}