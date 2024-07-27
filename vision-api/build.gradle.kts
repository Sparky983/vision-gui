plugins {
    id("vision.library-conventions")
}

dependencies {
    api("net.kyori:adventure-api:4.16.0") {
        exclude("org.jetbrains", "annotations")
    }
}

tasks {
    withType<JavaCompile> {
        options.release = 17
    }
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                sequenceOf("api", "key").forEach {
                    links("https://jd.advntr.dev/$it/4.14.0")
                }
            }
        }
    }
}
