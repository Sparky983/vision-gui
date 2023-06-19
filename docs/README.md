# Getting Started

## Vision GUI

Vision GUI is a minimal GUI API for Paper.

## Quick Links

* [API Javadoc](https://repo.sparky983.me/javadoc/releases/me/sparky983/vision/vision-api/0.2)
* [Paper Javadoc](https://repo.sparky983.me/javadoc/releases/me/sparky983/vision/vision-paper/0.2)
* [sparky983/vision-gui](https://github.com/sparky983/vision-gui)

## Installation

Add the following to your build configuration:

{% tabs %}
{% tab title="pom.xml" %}
```xml
<dependencies>
    <dependency>
        <groupId>me.sparky983.vision</groupId>
        <artifactId>vision-paper</artifactId>
        <version>0.1</version>
    </dependency>
</dependencies>
    
<repositories>
    <repository>
        <id>sparky983</id>
        <url>https://repo.sparky983.me/releases</url>
    </repository>
</repositories>
```
{% endtab %}

{% tab title="build.gradle" %}
```groovy
repositories {
    maven { url 'https://repo.sparky983.me/releases' }
}

dependencies {
    implementation 'me.sparky983.vision:vision-paper:0.1'
}
```
{% endtab %}

{% tab title="build.gradle.kts" %}
```kotlin
repositories {
    maven("https://repo.sparky983.me/releases")
}

dependencies {
    implementation("me.sparky983.vision:vision-paper:0.1")
}
```
{% endtab %}
{% endtabs %}
