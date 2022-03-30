import org.gradle.api.Project

const val ingsisCommon = "org.austral.ingsis.printscript:printscript-parser-common:0.1.0"
const val kotlinTest = "org.jetbrains.kotlin:kotlin-test"

internal fun Project.configureDependencies() {
    dependencies.add("implementation", ingsisCommon)
    dependencies.add("testImplementation", kotlinTest)
 }