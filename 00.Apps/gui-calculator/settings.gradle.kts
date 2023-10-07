rootProject.name = "calculator"

include("app")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("jdk", "17")
            version("javafx", "18.0.2")

            // https://plugins.gradle.org/
            plugin("kotlin-lang", "org.jetbrains.kotlin.jvm").version("1.8.10")
            plugin("jlink", "org.beryx.jlink").version("2.26.0")
            plugin("javafx", "org.openjfx.javafxplugin").version("0.0.13")
            plugin("javamodularity", "org.javamodularity.moduleplugin").version("1.8.12")

            // https://mvnrepository.com/
            library("kotlin-coroutines", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            library("junit-jupiter", "org.junit.jupiter:junit-jupiter:5.9.2")
        }
    }
}