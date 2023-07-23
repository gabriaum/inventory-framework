package com.github.gabriaum.inventory.command;

import com.github.gabriaum.inventory.demonstration.InventoryModel;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = ((Player) sender).getPlayer();

        new InventoryModel().handle(player);

        return true;
    }
}
