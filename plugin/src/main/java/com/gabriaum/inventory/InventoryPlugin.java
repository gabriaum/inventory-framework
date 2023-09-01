package com.gabriaum.inventory;

import com.gabriaum.inventory.engine.InventoryProctor;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryPlugin extends JavaPlugin {

    private InventoryProctor inventoryProctor;

    @Override
    public void onLoad() {
        inventoryProctor = new InventoryProctor(this);
    }

    @Override
    public void onEnable() {
        inventoryProctor.registry();
    }
}
