plugins {
    java
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
//    id("org.openapi.generator") version "7.13.0"
    id("openapi")
//    id("com.gini.xxx.dostuf")


}

//apply(plugin = "org.openapi.generator")

group = "com.gini"
version = "0.0.1-SNAPSHOT"
// Generate OpenAPI code for each file
//openApiFiles.forEach { (filePath, name) ->
//    generateOpenApi(
//        "generate${name}Api", // Unique task name for each file.
//        file(filePath).absolutePath,  // Use the absolute path
//        "com.example.${name.lowercase()}.api", // Unique package for each.
//        "com.example.${name.lowercase()}.model",
////        mapOf(
////            "apis" to name, // Generate API for the specific tag.
////        ),
//        mapOf(
//            "interfaceOnly" to "true",
//            "useSpringBoot3" to "true",
//            "dateLibrary" to "java8",
//            "useTags" to "true",
//            "skipDefaultInterface" to "true",
//            "useResponseEntity" to "false",
//            "useJakartaEe" to "true"
//        )
//    )
//}

// Configure the compileJava task to depend on all OpenAPI generation tasks.
//val allOpenApiTaskNames = openApiFiles.map { "generate${it.second}Api" }  // Correct task name.
//tasks.named("compileJava") {
//    dependsOn(allOpenApiTaskNames)
//    sourceSets {
//        main {
//            java.srcDir(layout.buildDirectory.dir("generated/src/main/java"))
//        }
//    }
//}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springModulithVersion"] = "1.3.5"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.modulith:spring-modulith-starter-core")
    implementation("org.springframework.modulith:spring-modulith-starter-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


    //need this dependencies for openapi generator
    implementation("io.swagger.core.v3:swagger-annotations-jakarta:2.2.30")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}


// configuration properties: https://openapi-generator.tech/docs/generators/spring/
//openApiGenerate {
//    generatorName.set("spring") // Use the Spring generator.
//    inputSpec.set("$projectDir/src/main/resources/openapi/openapi.yaml") // Path to your OpenAPI specification file.
//    outputDir.set(
//        layout.buildDirectory.dir("generated").get().asFile.absolutePath
//    ) // Output directory for the generated code.
//    apiPackage.set("com.example.api") // Package for the generated API classes.
//    modelPackage.set("com.example.model") // Package for the generated model classes.
//    verbose.set(true)
//    globalProperties.set(
//        mapOf(
//            "apis" to "Car,Customer",
//            "models" to "CarRequest,ModelRequest,Error,CustomerRequest"
////            "X_TAGS" to "CAR"
////            "models" to "CarRequest:ModelRequest"
//        )
//    )
//    configOptions.set(
//        mapOf(
//            // Optional:  Add these to avoid a few common codegen issues.
//            "interfaceOnly" to "true",  // Generate interfaces instead of classes for controllers.
//            "useSpringBoot3" to "true", // Ensure compatibility with Spring Boot 3. It will automatically set "useJakartaEe" to "true"
////            "useJakartaEe" to "true", // Use Jakarta EE
//            "dateLibrary" to "java8",
//            "useTags" to "true",
//            "skipDefaultInterface" to "true",
//            "useResponseEntity" to "false",
//
//        )
//    )
//}

//sourceSets {
//    main {
//        java.srcDir(
//            layout.buildDirectory.dir("generated/src/main/java").get().asFile.absolutePath
//        )  // Add the generated source directory.
//    }
//}

//tasks.named("compileJava") { dependsOn("openApiGenerate") }

//fun Project.generateOpenApi(
//    taskName: String,
//    inputSpecx: String,
//    apiPackage: String,
//    modelPackage: String,
////    globalProperties: Map<String, String> = emptyMap(),
//    configOptions: Map<String, String> = emptyMap()
//) {
//    tasks.register<org.openapitools.generator.gradle.plugin.tasks.GenerateTask>(taskName) {
//        generatorName.set("spring")
//
//        inputSpec.set(inputSpecx)
//        outputDir.set(
//            layout.buildDirectory.dir("generated").get().asFile.absolutePath
//        )
//        this.apiPackage.set(apiPackage)
//        this.modelPackage.set(modelPackage)
//        verbose.set(true)
////        this.globalProperties.set(globalProperties)
//        this.configOptions.set(configOptions)
//    }
//}


// List of OpenAPI specification files
val openApiFiles = listOf(
    "src/main/resources/openapi/openapi.yaml" to "Car", //Added names for the openapi files
    "src/main/resources/openapi/openapi.yaml" to "Customer"
    // Add more OpenAPI file paths here as needed.  Make sure the paths are correct.
)




// Generate OpenAPI code for each file
//openApiFiles.forEach { (filePath, name) ->
//    generateOpenApi(
//        "generate${name}Api", // Unique task name for each file.
//        file(filePath).absolutePath,  // Use the absolute path
//        "com.example.${name.lowercase()}.api", // Unique package for each.
//        "com.example.${name.lowercase()}.model",
////        mapOf(
////            "apis" to name, // Generate API for the specific tag.
////        ),
//        mapOf(
//            "interfaceOnly" to "true",
//            "useSpringBoot3" to "true",
//            "dateLibrary" to "java8",
//            "useTags" to "true",
//            "skipDefaultInterface" to "true",
//            "useResponseEntity" to "false",
//            "useJakartaEe" to "true"
//        )
//    )
//}

// Configure the compileJava task to depend on all OpenAPI generation tasks.
//val allOpenApiTaskNames = openApiFiles.map { "generate${it.second}Api" }  // Correct task name.
//tasks.named("compileJava") {
//    dependsOn(allOpenApiTaskNames)
//    sourceSets {
//        main {
//            java.srcDir(layout.buildDirectory.dir("generated/src/main/java"))
//        }
//    }
//}
val carTaskName = project.property("carTask") as String
val customerTaskName = project.property("customerTask") as String

tasks.named("compileJava") {
    dependsOn(carTaskName)
    sourceSets {
        main {
            java.srcDir(layout.buildDirectory.dir("generated/src/main/java"))
        }
    }
}