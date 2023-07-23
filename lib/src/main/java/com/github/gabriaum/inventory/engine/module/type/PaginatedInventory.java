package com.github.gabriaum.inventory.engine.module.type;

import com.github.gabriaum.inventory.engine.module.Paginated;
import org.bukkit.entity.Player;

public abstract class PaginatedInventory<T> extends Paginated<T> {

    public abstract void loadItem(Player human, T value);
}