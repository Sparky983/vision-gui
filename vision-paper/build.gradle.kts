plugins {
    id("vision.library-conventions")
}

description = "An implementation of Vision for the Paper API"

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":vision-api")) {
        exclude("net.kyori", "adventure-api")
    }

    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT") {
        exclude("org.jetbrains", "annotations")
    }

    testImplementation("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT") {
        exclude("org.jetbrains", "annotations")
    }
}

tasks {
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                links("https://jd.papermc.io/paper/1.19")
                links("https://javadoc.jitpack.io/me/sparky983/vision-gui/vision-api/2f95721ee1/javadoc")
                sequenceOf("api", "key").forEach {
                    links("https://jd.advntr.dev/$it/4.14.0")
                }
            }
        }
    }
}
