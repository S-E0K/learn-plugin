package org.se0k.learnplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LearnCommand extends BukkitCommand {

    public LearnCommand(@NotNull String name) {
        super(name); // 사용방법 : /test
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player player) {
            //Bukkit.getLogger().warning(player.getName());

            World world = player.getWorld();
            Location playerLocation = player.getLocation();
            Location location = new Location(world, playerLocation.getX(), playerLocation.getY() + 10, playerLocation.getZ());

            Block block = world.getBlockAt(playerLocation.getBlockX(), playerLocation.getBlockY() - 1, playerLocation.getBlockZ());
            Material type = block.getType();


            if (type == Material.AIR) {
                Bukkit.getLogger().warning("AIR");
            }
            else  Bukkit.getLogger().warning(type.toString());
        }

        return false;
    }

}
