plugins {
    java
    id("xyz.jpenilla.run-paper") version "2.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(project(":vision-paper"))
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    runServer {
        minecraftVersion("1.19.4")
    }
}
