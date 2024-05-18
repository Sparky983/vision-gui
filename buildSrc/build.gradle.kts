plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.22.0")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.28.0")
}
