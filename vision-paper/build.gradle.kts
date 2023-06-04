plugins {
    `java-library`
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    api(project(":vision-api"))

    compileOnly("org.jspecify:jspecify:0.2.0")
    // TODO: Update to 0.3.0 when more tools add support

    api("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT") {
        exclude("org.jetbrains:annotations")
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

tasks {
    compileJava {
        options.compilerArgs.add("-parameters")
    }
    javadoc {
        options {
            (this as StandardJavadocDocletOptions).run {
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
