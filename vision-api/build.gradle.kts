plugins {
    id("vision.library-conventions")
}

dependencies {
    api("me.sparky983.state:state:0.1.0")

    api("net.kyori:adventure-api:4.16.0") {
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
