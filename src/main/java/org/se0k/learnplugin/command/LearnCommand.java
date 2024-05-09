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

            World world = player.getWorld();
            Location playerLocation = player.getLocation();

            Location location1 = new Location(world, -10000, 60, -10000);
            Location location2 = new Location(world, 10000, 60, 10000);

            double checkX = Math.floor(Math.random() * 20000);
            double checkZ = Math.floor(Math.random() * 20000);


            location1.setX(checkX - 10000);
            location1.setZ(checkZ - 10000);






            Block block = world.getBlockAt(playerLocation.getBlockX(), playerLocation.getBlockY() - 1, playerLocation.getBlockZ());
            Material type = block.getType();

            player.teleport(location1);




//            for (double i = -60; i <= 320; i++) {
//
//
//            }





//            if (type == Material.AIR) {
//                Bukkit.getLogger().warning("AIR");
//            }
//            else  Bukkit.getLogger().warning(type.toString());
        }

        return false;
    }

}
