plugins {
    id("vision.java-conventions")
}

repositories {
    maven("https://jitpack.io")
    mavenCentral()
}

dependencies {
    implementation(project(":vision-minestom"))
    implementation("net.minestom:minestom-snapshots:1_20_5-3a6dfc6e67")
}
