# Kotlin DSL

## Installation

Add the following dependency to your build configuration:

{% tabs %}
{% tab title="pom.xml" %}
```markup
<dependencies>
    <dependency>
        <groupId>me.sparky983</groupId>
        <artifactId>vision-kotlin</artifactId>
        <version>0.2</version>
    </dependency>
</dependencies>
```
{% endtab %}

{% tab title="build.gradle" %}
```groovy
dependencies {
    implementation 'me.sparky983:vision-kotlin:0.2'
}
```
{% endtab %}

{% tab title="build.gradle.kts" %}
```kotlin
dependencies {
    implementation("me.sparky983:vision-kotlin:0.2")
}
```
{% endtab %}
{% endtabs %}

## Using the DSL

To create a `Gui` using the Kotlin GUI DSL, the `gui` method is used. The method takes in a single initializer block received by a `GuiDsl`.&#x20;

```kotlin
val gui = gui {
    title = Component.text("A GUI") // defaults to null
    rows = 3 // defaults to 3
    button(Slot.of(1, 4)) {
        type = ItemType.DIAMOND
        name = Component.text("A Button")
        lore = listOf(Component.text("Line 1"), Component.text("Line 2"))
        amount = 3
        onClick { click -> .. }
    }
}
```
