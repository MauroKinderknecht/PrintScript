import org.gradle.api.Project

const val kotlin = "kotlin"

internal fun Project.configurePlugins() {
    plugins.apply(kotlin)
}