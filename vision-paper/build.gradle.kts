plugins {
    id("vision.library-conventions")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":vision-api"))

    compileOnlyApi("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT") {
        exclude("org.jetbrains:annotations")
    }
}

tasks {
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                links("https://jd.papermc.io/paper/1.19")
                sequenceOf("api", "key").forEach {
                    links("https://jd.advntr.dev/$it/4.11.0")
                }
            }
        }
    }
}
