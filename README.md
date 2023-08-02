# Vision GUI

Vision GUI is a minimal GUI API for Paper.

## Quick Links

- [📔 Documentation](https://vision.sparky983.me/)

## Installation

Add the following to your build configuration:

<details>
<summary>pom.xml</summary>

```xml
<repositories>
    <repository>
        <id>sparky983</id>
        <url>https://repo.sparky983.me/releases</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>me.sparky983</groupId>
        <artifactId>vision-paper</artifactId>
        <version>1.0.1</version>
    </dependency>
</dependencies>
```
</details>

<details>

<summary>build.gradle</summary>

```groovy
repositories {
    maven { url 'https://repo.sparky983.me/releases' }
}

dependencies {
    implementation 'me.sparky983:vision-paper:1.0.1'
}
```
</details>

<details>

<summary>build.gradle.kts</summary>

```kotlin
repositories {
    maven("https://repo.sparky983.me/releases")
}

dependencies {
    implementation("me.sparky983:vision-paper:1.0.1")
}
```
</details>
