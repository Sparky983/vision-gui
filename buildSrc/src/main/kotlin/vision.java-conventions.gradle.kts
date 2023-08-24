plugins {
    java
    id("com.diffplug.spotless")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.mockito:mockito-core:5.5.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

spotless {
    java {
        palantirJavaFormat().style("GOOGLE")
        formatAnnotations()
    }
}

tasks.test {
    useJUnitPlatform()
}
