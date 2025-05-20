//https://docs.gradle.org/current/userguide/implementing_gradle_plugins_precompiled.html

plugins {
    id("org.openapi.generator")
}

fun Project.generateOpenApi(taskName: String,
                            inputSpecx: String,
                            apiPackage: String,
                            modelPackage: String,
                            configOptions: Map<String, String> = emptyMap()) {

    tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>(taskName) {
        generatorName.set("spring")
        inputSpec.set(inputSpecx)
        outputDir.set(layout.buildDirectory.dir("generated").get().asFile.absolutePath)
        this.apiPackage.set(apiPackage)
        this.modelPackage.set(modelPackage)
//        verbose.set(true)
        this.configOptions.set(configOptions)
    }
}

val carTaskName = project.property("carTask") as String
val customerTaskName = project.property("customerTask") as String

val openApiFiles = listOf(
    "src/main/resources/openapi/openapi.yaml" to carTaskName, //Added names for the openapi files
    "src/main/resources/openapi/openapi.yaml" to customerTaskName
    // Add more OpenAPI file paths here as needed.  Make sure the paths are correct.
)

// Generate OpenAPI code for each file
openApiFiles.forEach { (filePath, name) ->
    generateOpenApi(
        name, // Unique task name for each file.
        file(filePath).absolutePath,  // Use the absolute path
        "com.gini.generated.${name}.api", // Unique package for each.
        "com.gini.generated.${name}.model",
        mapOf(
            "interfaceOnly" to "true",
            "useSpringBoot3" to "true",
            "dateLibrary" to "java8",
            "useTags" to "true",
            "skipDefaultInterface" to "true",
            "useResponseEntity" to "false",
            "useJakartaEe" to "true"
        )
    )
}
