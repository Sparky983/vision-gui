plugins {
    id("vision.library-conventions")
}

dependencies {
    api("net.kyori:adventure-api:4.13.1") {
        exclude("org.jetbrains", "annotations")
    }
}
