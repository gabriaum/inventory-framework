###
<p>The Inventory Framework is a set of Java classes that provide advanced features for creating custom inventories in your Minecraft plugins. It was designed to simplify the complexity of handling inventory and items, allowing you to create attractive and interactive user interfaces for your players.</p>

<p>It is important to note that the Inventory Framework is not a replacement for the Bukkit API. It is a supplement to the Bukkit API, and is intended to be used alongside it.</p>

<details>
<summary>Static Inventories</summary>

```java
public class YourClass extends Inventory {

    public InventoryModel() {
        super("Title", 5 /* Rows */);

        moveItems(false); // Prevents items from being moved
    }

    @Override
    public void handle(Player human) {
        clear(); // Clears all inventory items

        add(3 /* Row */, 
            5 /* Column */, 
            new ItemHelper(Material.DIAMOND)
                .name("Hello World!")
                .lore(
                        "This is a test",
                        "of the lore"
                ).click(event -> human.sendMessage("Clicked!")));

        open(human); // Opens the inventory for the player
    }
}
```
</details>

<details>
<summary>Paginated Inventories</summary>

```java
public class InventoryModel extends Inventory {

    private final List<ItemHelper> itemHelperList;

    public InventoryModel() {
        super("Title", 5 /* Rows */);

        itemHelperList = Arrays.asList(
                new ItemHelper(Material.DIAMOND),
                new ItemHelper(Material.GOLDEN_APPLE),
                new ItemHelper(Material.GHAST_TEAR),
                new ItemHelper(Material.SAND),
                new ItemHelper(Material.DARK_OAK_FENCE_GATE),
                new ItemHelper(Material.ANVIL),
                new ItemHelper(Material.FEATHER),
                new ItemHelper(Material.GOLD_AXE),
                new ItemHelper(Material.SAPLING),
                new ItemHelper(Material.PAINTING),
                new ItemHelper(Material.BOOK),
                new ItemHelper(Material.BOOKSHELF),
                new ItemHelper(Material.BOW),
                new ItemHelper(Material.BOWL),
                new ItemHelper(Material.BREAD),
                new ItemHelper(Material.BED),
                new ItemHelper(Material.BRICK),
                new ItemHelper(Material.STONE_AXE),
                new ItemHelper(Material.BRICK_STAIRS),
                new ItemHelper(Material.STONE_BUTTON),
                new ItemHelper(Material.DIAMOND_AXE),
                new ItemHelper(Material.DROPPER),
                new ItemHelper(Material.BLAZE_ROD),
                new ItemHelper(Material.COMPASS)
        );

        moveItems(false); // Prevents items from being moved

        /*
         * X = Border
         * O = Items
         * < = Previous Page
         * > = Next Page
         */
        updateLayout(
                "XXXXXXXXX",
                "XOOOOOOOX",
                "XOOOOOOOX",
                "XOOOOOOOX",
                "<XXXXXXX>"
        );
    }

    @Override
    public void handle(Player human) {
        clear(); // Clears all inventory items

        updateSource(itemHelperList); // Update the source with the new items

        open(human); // Opens the inventory for the player
    }
}
```
</details>

<details>
<summary>Present Methods</summary>

<ul>
    <li><code>open(Player human)</code>: Opens the player's inventory;</li>
    <li><code>updateLayout(String... layout)</code>: Updates the inventory layout with a new custom layout;</li>
    <li><code>updateSource(List<'ItemHelper'> source)</code>: Updates the list of flexible inventory items;</li>
    <li><code>moveItems(boolean val)</code>: Defines whether or not items should be moved to the same slot when updating inventory;</li>
    <li><code>play(Player human, SoundType sound)</code>: Plays a sound imported from the library;</li>
    <li><code>add(int row, int column, ItemHelper item)</code>: Adds a static item to the inventory at a specific position;</li>
    <li><code>add(ItemHelper item)</code>: Adds a flex item to the inventory;</li>
    <li><code>remove(ItemHelper item)</code>: Removes an item from inventory based on its instance;</li>
    <li><code>clear()</code>: Removes all items from inventory;</li>
</ul>
</details>