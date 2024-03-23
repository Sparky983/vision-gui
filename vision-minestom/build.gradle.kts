plugins {
    id("vision.library-conventions")
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    api(project(":vision-api"))
    implementation("dev.hollowcube:minestom-ce:aec3694a4a")
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
