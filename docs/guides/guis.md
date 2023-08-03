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

You can create a `Gui` using the builder:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.chest()
        .title(Component.text("A GUI"))
        .rows(3)
        .build();
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.chest()
        .title(Component.text("A GUI"))
        .rows(3)
        .build()
```
{% endtab %}
{% endtabs %}

A dropper or hopper can be created using their builders:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.dropper()
        .title(Component.text("A GUI"))
        .build();        
```

```java
Gui gui = Gui.hopper()
        .title(Component.text("A GUI"))
        .build();
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.dropper()
        .title(Component.text("A GUI"))
        .build()
```

```kotlin
val gui = Gui.hopper()
        .title(Component.text("A GUI"))
        .build()
```
{% endtab %}
{% endtabs %}

## Adding Buttons

A `Button` can be added by chaining a `button(Slot, Button)` call:

{% hint style="info" %}
Air is always represented by a `null` `Button`.
{% endhint %}

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.chest()
        .button(Slot.of(1, 4), Button.of(ItemType.STONE))
        .build();
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.chest()
        .button(Slot(1, 4), Button.of(ItemType.STONE))
        .build()
```
{% endtab %}
{% endtabs %}

The method may also be called on a built `Gui`:

{% tabs %}
{% tab title="Java" %}
```java
gui.button(Slot.of(1, 4), Button.of(ItemType.STONE));
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
gui.button(Slot(1, 4), Button.of(ItemType.STONE))
```
{% endtab %}
{% endtabs %}

For more information relating to buttons, see [Buttons](buttons.md).

### Borders and Filling

`border(Button)` can be used to fill a border:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.chest()
        .border(Button.of(ItemType.GRAY_STAINED_GLASS_PANE)) // all sides
        .build();

Gui gui = Gui.chest()
        .border(Button.of(ItemType.GRAY_STAINED_GLASS_PANE), Border.BOTTOM)
        .build();
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.chest()
        .border(Button.of(ItemType.GRAY_STAINED_GLASS_PANE)) // all sides
        .build()

val gui = Gui.chest()
        .border(Button.of(ItemType.GRAY_STAINED_GLASS_PANE), Border.BOTTOM)
        .build()
```
{% endtab %}
{% endtabs %}

To fill the entire GUI, `fill(Button)` can be used:



{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.chest()
        .fill(Button.of(ItemType.GRAY_STAINED_GLASS_PANE))
        .build();
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.chest()
        .fill(Button.of(ItemType.GRAY_STAINED_GLASS_PANE))
        .build()
```
{% endtab %}
{% endtabs %}

## Close Handling

To handle when a player closes a GUI, you can use `onClose(Consumer<Close>)`:

{% tabs %}
{% tab title="Java" %}
```java
Gui gui = Gui.chest()
        .build()
        .onClose(close -> {
            Audience closer = close.closer();
            
            // reopen the GUI
            close.open(close.gui());
        });
```
{% endtab %}

{% tab title="Kotlin" %}
```kotlin
val gui = Gui.chest()
        .build()
        .onClose { close ->
            val player = close.player()
            
            // reopen the GUI
            close.open(close.gui())
        }
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
