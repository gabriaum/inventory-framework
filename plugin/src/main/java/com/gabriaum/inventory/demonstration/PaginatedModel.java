package com.gabriaum.inventory.demonstration;

import com.gabriaum.inventory.demonstration.object.Shop;
import com.gabriaum.inventory.engine.stack.ItemHelper;
import com.gabriaum.inventory.engine.Inventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginatedModel extends Inventory {

    private final List<Shop> list;

    public PaginatedModel() {
        super("Title", 5);

        list = Arrays.asList(
                new Shop("A", 1),
                new Shop("B", 2),
                new Shop("C", 3),
                new Shop("D", 4)
        );

        moveItems(false); // Prevents items from being moved
        getConfiguration().setUseLayout(true);

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

        List<ItemHelper> source = new ArrayList<>();

        for (Shop value : list) {
            ItemHelper item = new ItemHelper(Material.EMERALD)
                    .name("§a" + value.getName())
                    .lore("§7Price: §6" + value.getPrice())
                    .click(event -> event.getWhoClicked().sendMessage("§aYou purchased the item " + value.getName() + "."));

            source.add(item);
        }

        updateSource(source); // Update the source with the new items

        open(human); // Opens the inventory for the player
    }
}
