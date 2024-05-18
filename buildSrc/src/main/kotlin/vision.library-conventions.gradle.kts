import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    `java-library`
    id("vision.java-conventions")
    id("com.vanniktech.maven.publish")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("org.jspecify:jspecify:0.3.0")
    // TODO: Update to 0.3.0 when more tools add support
}

val isSnapshot = project.version.toString().endsWith("-SNAPSHOT")

mavenPublishing {
    configure(JavaLibrary(
        javadocJar = JavadocJar.Javadoc(),
        sourcesJar = true,
    ))
    if (!isSnapshot) {
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    pom {
        description.set(project.description ?: throw IllegalStateException("Add a project description"))
        url.set("https://github.com/Sparky983/vision-gui/")
        licenses {
            license {
                name.set("MIT License")
                url.set("https://www.opensource.org/licenses/mit-license")
            }
        }
        developers {
            developer {
                id.set("Sparky983")
            }
        }
        scm {
            url.set("https://github.com/Sparky983/vision-gui/")
            connection.set("scm:git:git://github.com/Sparky983/vision-gui.git")
            developerConnection.set("scm:git:ssh://git@github.com/Sparky983/vision-gui.git")
        }
    }
}

publishing {
    repositories {
        if (isSnapshot) {
            maven {
                name = "sparky983"
                url = uri("https://repo.sparky983.me/snapshots")
                credentials(PasswordCredentials::class)
                authentication {
                    create<BasicAuthentication>("basic")
                }
            }
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
