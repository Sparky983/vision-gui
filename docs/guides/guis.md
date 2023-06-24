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

# GUIs

## Creating a GUI

You can create a `Gui` using the type-safe builder:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.gui()
        .title(Component.text("A GUI"))
        .rows(3); // The Gui is built once the rows have been specified
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.gui()
        .title(Component.text("A GUI"))
        .rows(3) // The Gui is built once the rows have been specified
```
{% endtab %}
{% endtabs %}

## Adding Buttons

{% hint style="info" %}
Air is always represented by a `null` `Button`.
{% endhint %}

`Button`s are added using the `Gui.button()` method.

{% tabs %}
{% tab title="Java" %}
```java
gui.button(Slot.of(1, 4), Button.of(ItemType.STONE));
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
gui.button(Slot.of(1, 4), Button.of(ItemType.DIAMOND))
```
{% endtab %}
{% endtabs %}

The method can also be chained:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.gui()
        .title(Component.text("A GUI"))
        .rows(3)
        .button(Slot.of(1, 4), Button.of(ItemType.DIAMOND));
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.gui()
        .title(Component.text("A GUI"))
        .rows(3)
        .button(Slot.of(1, 4), Button.of(ItemType.DIAMOND))
```
{% endtab %}
{% endtabs %}

## Opening The GUI

To open a `Gui`, you need to first create a `PaperVision`:

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

Then you can open it:

{% tabs %}
{% tab title="Java" %}
```java
Player player = ...;
vision.open(player, gui);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val player: Player = ..
vision.open(player, gui)
```
{% endtab %}
{% endtabs %}
