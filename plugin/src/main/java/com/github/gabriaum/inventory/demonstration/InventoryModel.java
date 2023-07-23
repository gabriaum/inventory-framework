package com.github.gabriaum.inventory.demonstration;

import com.github.gabriaum.inventory.demonstration.object.Fodastico;
import com.github.gabriaum.inventory.engine.module.type.PaginatedInventory;
import com.github.gabriaum.inventory.engine.stack.ItemHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class InventoryModel extends PaginatedInventory<Fodastico> {

    private final List<Fodastico> list;

    public InventoryModel() {
        super("Title", 5 /* Rows */);

        list = Arrays.asList(
                new Fodastico("A", 1),
                new Fodastico("B", 2),
                new Fodastico("C", 3),
                new Fodastico("D", 4)
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

        updateSource(list); // Update the source with the new items

        open(human); // Opens the inventory for the player
    }

    @Override
    public void loadItem(Player human, Fodastico value) {
        modelAdd(
                new ItemHelper(Material.ITEM_FRAME)
                        .name("§a" + value.getName())
                        .lore("§7" + value.getPrice())
        );
    }
}
