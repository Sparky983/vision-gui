---
layout:
  title:
    visible: true
  description:
    visible: false
  tableOfContents:
    visible: true
  outline:
    visible: true
  pagination:
    visible: true
---

# Getting Started

## Vision GUI

Vision GUI is a minimal GUI API for Paper.

## Quick Links

* [API Javadoc](https://jitpack.io/me/sparky983/vision-gui/vision-api/c4487b7dbe/javadoc/)
* [Paper Javadoc](https://jitpack.io/me/sparky983/vision-gui/vision-paper/c4487b7dbe/javadoc/)
* [Sparky983/vision-gui](https://github.com/sparky983/vision-gui)

## Installation

Add the following to your build configuration:

{% tabs %}
{% tab title="pom.xml" %}
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
        <version>1.0.0</version>
    </dependency>
</dependencies>
```
{% endtab %}

{% tab title="build.gradle" %}
```groovy
repositories {
    maven { url 'https://repo.sparky983.me/snapshots' }
}

dependencies {
    implementation 'me.sparky983:vision-paper:1.0.0-SNAPSHOT'
}
```
{% endtab %}

{% tab title="build.gradle.kts" %}
```kotlin
repositories {
    maven("https://repo.sparky983.me/snapshots")
}

dependencies {
    implementation("me.sparky983:vision-paper:1.0.0-SNAPSHOT")
}
```
{% endtab %}
{% endtabs %}
