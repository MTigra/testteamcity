import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.githubConnection

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.2"

project {

    subProject {

        name = "TSHS"
        id = RelativeId("TSHS");
        buildType(ReplaceFluentFromCIDockerRepotoCDTestDockerRepo)
    }

    features {
        githubConnection {
            id = "PROJECT_EXT_4"
            displayName = "GitHub.com"
            clientId = "a1a4bcc965d19e672760"
            clientSecret = "credentialsJSON:b33856a2-dae0-4df5-a6f5-261bd7ef158b"
        }
    }
}

object ReplaceFluentFromCIDockerRepotoCDTestDockerRepo : BuildType({
    name = "Logger | fluent-bit | Replace Fluent From CI Docker Repo to CD Test Docker Repo"

    steps {
        script {
            scriptContent = """
               ls
            """.trimIndent()
        }
    }
})

