plugins {
    id("vision.library-conventions")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":vision-api"))

    api("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT") {
        exclude("org.jetbrains:annotations")
    }
}
