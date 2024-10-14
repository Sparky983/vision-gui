plugins {
    `java-library`
    `maven-publish`
    id("vision.java-conventions")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:26.0.1")
    compileOnly("org.jspecify:jspecify:1.0.0")
}

java {
    withJavadocJar()
    withSourcesJar()
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
}
