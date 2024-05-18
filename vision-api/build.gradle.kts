plugins {
    id("vision.library-conventions")
}

description = "A platform-independent inventory API"

dependencies {
    api("net.kyori:adventure-api:4.15.0") {
        exclude("org.jetbrains", "annotations")
    }
}

tasks {
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
