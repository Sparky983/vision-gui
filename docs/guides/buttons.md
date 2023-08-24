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

# Buttons

## Creating a Button

A `Button` can be created using either the `Button.of(ItemType)` factory method.

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.of(ItemType.DIAMOND);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button: Button = Button.of(ItemType.DIAMOND)
```
{% endtab %}
{% endtabs %}

## Button Styling

You can use any of the following methods to style a`Button`:

{% hint style="info" %}
Any updates to a `Button` will be immediately reflected in the `Gui` without having to explicitly update the `Gui`.
{% endhint %}

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.of(ItemType.DIAMOND)
        .name(Component.text("A Button"))
        .lore(Component.text("Line 1"), Component.text("Line 2"))
        .glow(true)
        .amount(3);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button = Button.of(ItemType.DIAMOND)
        .name(Component.text("My Button"))
        .lore(Component.text("Line 1"), Component.text("Line 2"))
        .amount(3)
```
{% endtab %}
{% endtabs %}

## Click Handling

`Button` clicks can be handled using the `onClick(Consumer<Click>)` method:

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.of(ItemType.DIAMOND)
        .onClick(click -> {
            Audience clicker = click.clicker(); // who clicked
            ClickType type = click.type(); // click type (left, right, etc)
            
            if (clicker instanceof Player player) {
                // check if the clicker is a player
            }
        });
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button = Button.of(ItemType.DIAMOND)
        .onClick { click -> 
            val clicker = click.clicker() // who clicked
            val type = click.type() // click type (left, right, etc)
            
            if (clicker is Player) {
                // check if the clicker is a player
            }
        }
```
{% endtab %}
{% endtabs %}
