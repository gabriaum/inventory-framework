###
<p>The Item Helper is an Inventory Framework tool made to simplify the transit of items in projects that use the Bukkit API. With the ItemHelper class, you can easily create custom items with specific metadata and actions, providing a richer and more interactive experience for players.</p>
<p>We hope that this documentation has been useful for you to understand the use of this tool. If you have any questions or suggestions for improvement, feel free to get in touch or contribute to the project on GitHub.</p>

<details>
<summary>Basic Use</summary>

<h3>1. Creating a new object:</h3>

```java
ItemHelper item = new ItemHelper(Material.SPECIFY_MATERIAL);
```

<h3>2. Defining the name and lore of the object:</h3>

```java
item.name("Here goes the name!")
    .lore("Here goes the lore!");
```

<h3>3. Defining the action when the player interacts with the item:</h3>

<details>
<summary>Inventory Click</summary>

```java
item.click(event -> {
    // Here goes the action
});
```
</details>

<details>
<summary>Player Interact</summary>

```java
item.interact(event -> {
    // Here goes the action
});
```
</details>

<h3>4. Defining an update:</h3>

```java
item.updater(() -> {
    // Here goes the action
});
```

<h3>5. Meta-Data (NBT Tag):</h3>

<details>
<summary>Definition</summary>

```java
item.updateNBT("key", "value")
```
</details>

<details>
<summary>Consultation</summary>

```java
item.getNBT("key")
```
</details>
<h3/>
</details>

<details>
<summary>Present Methods</summary>

<ul>
    <li><code>ItemHelper(Material material)</code>: Defines the item material;</li>
    <li><code>ItemHelper(Material material, int amount)</code>: Defines the item material and amount;</li>
    <li><code>ItemHelper(Material material, int amount, int durability)</code>: Defines the item material, amount and durability;</li>
    <li><code>ItemHelper(String skullUrl)</code>: Define a custom SKULL_ITEM by skin url.;</li>
    <li><code>ItemHelper(Player skullByPlayer)</code>: Define a custom SKULL_ITEM by skin player (collection by name);</li>
    <li><code>read(ItemStack item)(ItemStack item)</code>: Perform a search for the item;</li>
    <li><code>name(String name)</code>:  Set the object name;</li>
    <li><code>lore(String lore)</code>: Set the object lore;</li>
    <li><code>lore(String... lore)</code>: Defines a list of lines for the item description;</li>
    <li><code>lore(List<String> lore)</code>: Defines a list of lines for the item description;</li>
    <li><code>click(Consumer<'InventoryClickEvent'> action)</code>: Sets item click action on inventories;</li>
    <li><code>interact(Consumer<'PlayerInteractEvent'> action)</code>: Defines the interaction action of the item by the player;</li>
    <li><code>updater(Runnable action)</code>: Defines an action to be performed every time the item is updated;</li>
     <li><code>updateRGB(int r, int g, int b)</code>: Defines an RGB color on the object. (Only for Leather Armors);</li>
    <li><code>updateNBT(String key, String value)</code>: Updates a specific value in the NBT (NBT Tag) of the item;</li>
    <li><code>getNBT(String key)</code>: Gets the value of a specific key in the item's NBT.</li>
</ul>
</details>

<details>
<summary>Practical Example</summary>

```java
PlayerInventory inventory = human.getInventory();

ItemHelper item = new ItemHelper(Material.DIAMOND)
        .updateNBT("hello", "world!")
        .name("Hello World!")
        .lore(
        "This is a test",
        "of the lore"
        ).interact(event -> human.sendMessage("Interacted!"))
        .click(event -> human.sendMessage("Clicked!"));

inventory.setItem(inventory.firstEmpty(), item);
```
</details>