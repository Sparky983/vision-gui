plugins {
    id("vision.java-conventions")
    id("xyz.jpenilla.run-paper") version "2.2.4"
    id("io.github.goooler.shadow") version "8.1.7"
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(project(":vision-paper"))
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
}

tasks {
    runServer {
        minecraftVersion("1.20")
    }
}
