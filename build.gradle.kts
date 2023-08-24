plugins {
    java
    id("com.diffplug.spotless") version "6.19.0"
}

repositories {
    mavenCentral()
}

spotless {
    java {
        palantirJavaFormat().style("GOOGLE")
        formatAnnotations()
    }
    kotlinGradle {
        ktlint()
    }
}
