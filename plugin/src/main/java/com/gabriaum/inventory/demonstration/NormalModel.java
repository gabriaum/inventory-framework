package com.gabriaum.inventory.demonstration;

import com.gabriaum.inventory.engine.stack.ItemHelper;
import com.gabriaum.inventory.engine.Inventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class NormalModel extends Inventory {
    public NormalModel() {
        super("Title", 3);

        moveItems(false);
    }

    @Override
    public void handle(Player human) {
        clear();

        add(2, 5, new ItemHelper(Material.STAINED_GLASS_PANE, 1, 4)
                .name("§aClick me!")
                .click(event -> event.getWhoClicked().sendMessage("§aThank you for clicking me!")));

        open(human);
    }
}
