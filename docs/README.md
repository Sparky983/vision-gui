# Quick Start

## Vision GUI

Vision GUI is a minimal GUI API for Paper.

### Quick Links

* [API Javadoc](https://repo.sparky983.me/javadoc/snapshots/me/sparky983/vision/vision-api/0.2-SNAPSHOT)
* [Paper Javadoc](https://repo.sparky983.me/javadoc/snapshots/me/sparky983/vision/vision-paper/0.2-SNAPSHOT)

### Installation

Add the following to your build configuration:

{% tabs %}
{% tab title="pom.xml" %}
```markup
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
        <url>https://repo.sparky983.me</url>
    </repository>
</repositories>
```
{% endtab %}

{% tab title="build.gradle" %}
```groovy
repositories {
    maven { url 'https://repo.sparky983.me' }
}

dependencies {
    implementation 'me.sparky983.vision:vision-paper:0.1'
}
```
{% endtab %}

{% tab title="build.gradle.kts" %}
```kotlin
repositories {
    maven("https://repo.sparky983.me")
}

dependencies {
    implementation("me.sparky983.vision:vision-paper:0.1")
}
```
{% endtab %}
{% endtabs %}

### Hello World GUI

First create an instance of the Vision API.

{% tabs %}
{% tab title="Java" %}
```java
PaperVision vision = PaperVision.create(plugin);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val vision = PaperVision.create(plugin)
```
{% endtab %}
{% endtabs %}

Then create the GUI:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.gui()
        .title(Component.text("Hello World"))
        .rows(3)
        .button(Slot.of(1, 4), Button.button()
                .name(Component.text("Hello World"))
                .type(ItemType.STONE)
                .onClick((click) -> {
                    click.clicker().sendMessage(Component.text("Hello World"));
                }));
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.gui()
        .title(Component.text("Hello World"))
        .rows(3)
        .button(Slot.of(1, 4), Button.button()
                .name(Component.text("Hello World"))
                .type(ItemType.STONE)
                .onClick {
                    it.clicker().sendMessage(Component.text("Hello World")) 
                })
```
{% endtab %}
{% endtabs %}

This code creates a GUI with a button that when the button clicked sends a "Hello World" message to the player.

And finally open the GUI:

{% tabs %}
{% tab title="Java" %}
```java
vision.open(player, gui);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
vision.open(player, gui)
```
{% endtab %}
{% endtabs %}
