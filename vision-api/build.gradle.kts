plugins {
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("org.jspecify:jspecify:0.2.0")
    // TODO: Update to 0.3.0 when more tools add support

    api("net.kyori:adventure-api:4.13.1") {
        exclude("org.jetbrains", "annotations")
    }

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.mockito:mockito-core:5.2.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

publishing {
    repositories {
        maven {
            name = "sparky983"
            url = uri(if (version.toString().endsWith("-SNAPSHOT")) {
                "https://repo.sparky983.me/snapshots"
            } else {
                "https://repo.sparky983.me/releases"
            })
            credentials(PasswordCredentials::class)
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks {
    compileJava {
        options.compilerArgs.add("-parameters")
    }
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
                tags("vision.experimental:a:Experimental:")
                tags("vision.implNote:a:Implementation Note:")
                tags("vision.apiNote:a:API Note:")
                tags("vision.examples:a:Examples:")
            }
        }
    }
    test {
        useJUnitPlatform()
    }
}
