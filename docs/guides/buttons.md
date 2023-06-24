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

A `Button` can be created using either the `Button.of()` method or the `Button.button()` builder:

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.of(ItemType.DIAMOND);

// or with the builder
Button button = Button.button()
        .type(ItemType.DIAMOND);

Button button = Button.button(); // error: type must be specified
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button: Button = Button.of(ItemType.DIAMOND)

// or with the builder
val button: Button = Button.button()
        .type(ItemType.DIAMOND)

val button: Button = Button.button() // error: type must be specified
```
{% endtab %}
{% endtabs %}

## Button Styling

Both built `Button` instances and `Button.Builder` instances can be styled using the same methods.

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.of(ItemType.DIAMOND)
        .name(Component.text("A Button")
        .lore(Component.text("Line 1"), Component.text("Line 2"))
        .amount(3);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button = Button.of(ItemType.DIAMOND)
        .name(Component.text("My Button")
        .lore(Component.text("Line 1"), Component.text("Line 2"))
        .amount(3)
```
{% endtab %}
{% endtabs %}

## Click Handling

`Button` clicks can be handled using the `Button.onClick()` method:

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.of(ItemType.DIAMOND)
        .onClick(click -> {
            Audience clicker = click.clicker(); // who clicked
            Click.Type type = click.type(); // click type (left, right, etc)
            
            if (clicker instanceof Player player) {
                // check if the clicker is a player
            }
        });
```
{% endtab %}

{% tab title="Kotlin" %}
<pre class="language-kotlin"><code class="lang-kotlin"><strong>val button = Button.of(ItemType.DIAMOND)
</strong>        .onClick { click -> 
            val clicker = click.clicker() // who clicked
            val type = click.type() // click type (left, right, etc)
            
            if (clicker is Player) {
                // check if the clicker is a player
            }
        }
</code></pre>
{% endtab %}
{% endtabs %}

## The Button Builder

`Button` instances can alternatively be built using the `Button.Builder`:

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.button()
        .name(Component.text("A Button")
        .lore(Component.text("Line 1"), Component.text("Line 2"))
        .amount(3)
        .onClick(click -> ...)
        .type(ItemType.DIAMOND);
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button = Button.button()
        .name(Component.text("A Button")
        .lore(Component.text("Line 1"), Component.text("Line 2"))
        .amount(3)
        .onClick { click -> .. }
        .type(ItemType.DIAMOND)
```
{% endtab %}
{% endtabs %}

### Builder Type Safety

The `Button.Builder` is type-safe, requiring an `ItemType` to be specified.

{% tabs %}
{% tab title="Java" %}
```java
Button button = Button.button()
        .name(Component.text("A Button")
        .type(ItemType.DIAMOND);
// valid

Button button = Button.button()
        .name(Component.text("A Button")
        .type(ItemType.DIAMOND)
        .amount(3);
// valid

Button button = Button.button()
        .name(Component.text("A Button"));
// invalid, the item type wasn't specified

Button.Builder builder = Button.button()
        .name(Component.text("A Button"));
// valid
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val button: Button = Button.button()
        .name(Component.text("A Button")
        .type(ItemType.DIAMOND)
// valid

val button: Button = Button.button()
        .name(Component.text("A Button")
        .type(ItemType.DIAMOND)
        .amount(3)
// valid

val button: Button = Button.button()
        .name(Component.text("A Button"))
// invalid, the item type wasn't specified

val builder: Button.Builder = Button.button()
        .name(Component.text("A Button"))
// valid
```
{% endtab %}
{% endtabs %}
