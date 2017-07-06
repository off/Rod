package com.glenjendary.rod.commands;

import com.glenjendary.rod.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


/* Rod Created by Glenjendary on 6/07/2017. */

public class Rod implements CommandExecutor {

    private Main plugin;
    public Rod(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        Inventory inv = player.getInventory();
        ItemStack rodMe = new ItemStack(Material.FISHING_ROD, 1);
        int slot = inv.firstEmpty();

        Location loc = player.getLocation();
        World world = player.getWorld();

        if (cmd.getName().equalsIgnoreCase("rod") && (!inv.contains(Material.FISHING_ROD))){
            if (slot == -1) {
                player.sendMessage(ChatColor.RED + "No room for a fishing rod in your inventory, one has been dropped at your location!");
                world.dropItemNaturally(loc, rodMe);
            } else if (slot >= 0 || slot < 36) {
                player.sendMessage(ChatColor.GREEN + "You have been given a fishing rod!");
                inv.setItem(slot, rodMe);
            }

        } else {
            player.sendMessage(ChatColor.RED + "You already have a fishing rod in your inventory!");
        }
        return false;
    }
}
