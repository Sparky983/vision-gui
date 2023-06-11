plugins {
    id("vision.library-conventions")
}

dependencies {
    api("net.kyori:adventure-api:4.13.1") {
        exclude("org.jetbrains", "annotations")
    }
}

tasks {
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                sequenceOf("api", "key").forEach {
                    links("https://jd.advntr.dev/$it/4.11.0")
                }
            }
        }
    }
}
