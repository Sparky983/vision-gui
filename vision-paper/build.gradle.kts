plugins {
    id("vision.library-conventions")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    api(project(":vision-api")) {
        exclude("net.kyori", "adventure-api")
    }

    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT") {
        exclude("org.jetbrains", "annotations")
    }

    testImplementation("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT") {
        exclude("org.jetbrains", "annotations")
    }
}

tasks {
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                links("https://jd.papermc.io/paper/1.20.6")
                links("https://javadoc.jitpack.io/me/sparky983/vision-gui/vision-api/2f95721ee1/javadoc")
                sequenceOf("api", "key").forEach {
                    // TODO: 4.17.0
                    links("https://jd.advntr.dev/$it/4.16.0")
                }
            }
        }
    }
}
