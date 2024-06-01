plugins {
    id("vision.library-conventions")
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    api(project(":vision-api"))
    implementation("net.minestom:minestom-snapshots:1_20_5-3a6dfc6e67")
}

tasks {
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                links("https://javadoc.minestom.net/")
                links("https://javadoc.jitpack.io/me/sparky983/vision-gui/vision-api/2f95721ee1/javadoc")
                sequenceOf("api", "key").forEach {
                    links("https://jd.advntr.dev/$it/4.14.0")
                }
            }
        }
    }
}
