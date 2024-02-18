plugins {
    id("vision.java-conventions")
}

repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation(project(":vision-minestom"))
    implementation("dev.hollowcube:minestom-ce:aec3694a4a")
}
