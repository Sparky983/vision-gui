# Vision GUI

Vision GUI is a minimal GUI API for Paper.

## Quick Links

- [API Javadoc](https://repo.sparky983.me/javadoc/snapshots/me/sparky983/vision/vision-api/0.2-SNAPSHOT)
- [Paper Javadoc](https://repo.sparky983.me/javadoc/snapshots/me/sparky983/vision/vision-paper/0.2-SNAPSHOT)

## Table of Contents

1. [Quick Start](#quick-start)
    1. [Installation](#installation)
    2. [Hello World GUI](#hello-world-gui)

## Quick Start

### Installation

Add the following to your build configuration:

=== "Maven"
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
            <url>https://repo.sparky983.me</url>
        </repository>
    </repositories>
    ```
    
=== "Gradle (Groovy DSL)"
    ```groovy
    repositories {
        maven { url 'https://repo.sparky983.me' }
    }
    
    dependencies {
        implementation 'me.sparky983.vision:vision-paper:0.1'
    }
    ```

=== "Gradle (Kotlin DSL)"
    
    ```kotlin
    repositories {
        maven("https://repo.sparky983.me")
    }
    
    dependencies {
        implementation("me.sparky983.vision:vision-paper:0.1")
    }
    ```

### Hello World GUI


First create an instance of the Vision API.

=== "Java"
    ```java
    PaperVision vision = PaperVision.create(plugin);
    ```
=== "Kotlin"
    ```kotlin
    val vision = PaperVision.create(plugin)
    ```

Then create the GUI:

=== "Java"
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

=== "Kotlin"
    ```kotlin
    val gui = Gui.gui()
            .title(Component.text("Hello World"))
            .rows(3)
            .button(Slot.of(1, 4), Button.button()
                    .name(Component.text("Hello World"))
                    .type(ItemType.STONE)
                    .onClick { it.clicker().sendMessage(Component.text("Hello World")) })
    ```

This code creates a GUI with a button that when the button clicked sends a "Hello World" message
to the player.

And finally open the GUI:

=== "Java" 
    ```java
    vision.open(player, gui);
    ```

=== "Kotlin"
    ```kotlin
    vision.open(player, gui)
    ```
