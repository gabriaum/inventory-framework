package com.github.gabriaum.inventory.engine;

import com.github.gabriaum.inventory.engine.controller.list.InventoryController;
import com.github.gabriaum.inventory.engine.event.scheduler.UpdateScheduler;
import com.github.gabriaum.inventory.engine.listener.InventoryListener;
import com.github.gabriaum.inventory.engine.listener.ItemListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

@RequiredArgsConstructor
public class InventoryProctor {

    private final Plugin plugin;

    @Getter
    private static InventoryController controller = new InventoryController();

    public void registry() {
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new ItemListener(), plugin);
        Bukkit.getScheduler().runTaskTimer(plugin, () -> new UpdateScheduler().run(), 1, 1);
    }
}