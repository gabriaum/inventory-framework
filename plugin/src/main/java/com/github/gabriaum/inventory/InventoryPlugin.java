package com.github.gabriaum.inventory;

import com.github.gabriaum.inventory.command.InventoryCommand;
import com.github.gabriaum.inventory.engine.InventoryProctor;
import com.github.gabriaum.inventory.listener.ListenerProctor;
import org.bukkit.plugin.java.JavaPlugin;

public class InventoryPlugin extends JavaPlugin {

    private ListenerProctor listenerProctor;
    private InventoryProctor inventoryProctor;

    @Override
    public void onLoad() {
        listenerProctor = new ListenerProctor(this);
        inventoryProctor = new InventoryProctor(this);
    }

    @Override
    public void onEnable() {
        listenerProctor.registry("com.github.gabriaum.inventory.listener");
        inventoryProctor.registry();

        getServer().getPluginCommand("inventory").setExecutor(new InventoryCommand());
    }

    @Override
    public void onDisable() {

    }
}
