package com.github.gabriaum.inventory.engine.listener;

import com.github.gabriaum.inventory.engine.module.type.Inventory;
import com.github.gabriaum.inventory.engine.InventoryProctor;
import com.github.gabriaum.inventory.engine.event.UpdateEvent;
import com.github.gabriaum.inventory.engine.event.type.UpdateType;
import com.github.gabriaum.inventory.engine.stack.ItemHelper;
import com.github.gabriaum.inventory.engine.stack.action.ItemClick;
import com.github.gabriaum.inventory.engine.stack.action.ItemUpdater;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class InventoryListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void clickMaker(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();

        if (holder instanceof Inventory) {
            Inventory inventory = (Inventory) holder;
            ItemHelper item = inventory.getItems().get(event.getSlot());

            if (item == null)
                return;

            if (event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR))
                return;

            event.setCancelled(!inventory.getConfiguration().isMoveItems());

            if (!inventory.getConfiguration().isMoveItems())
                event.getWhoClicked().setItemOnCursor(null);

            ItemClick click = item.getClick();

            if (click != null) {
                click.run(event);
            }
        }
    }

    @EventHandler
    public void updater(UpdateEvent event) {
        if (event.isType(UpdateType.SECOND)) {
            InventoryProctor.getController().getMap().values().forEach(inventories -> {
                for (ItemHelper item : inventories.getItems().values()) {
                    if (item == null)
                        continue;

                    if (item.getType().equals(Material.AIR))
                        continue;

                    ItemUpdater updater = item.getUpdater();

                    if (updater == null)
                        continue;

                    updater.run();
                }
            });
        }
    }
}