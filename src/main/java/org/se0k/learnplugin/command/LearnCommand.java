package org.se0k.learnplugin.command;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LearnCommand extends BukkitCommand {

    public LearnCommand(@NotNull String name) {
        super(name); // 사용방법 : /test
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String s, @NotNull String[] strings) {

        if (!(sender instanceof Player player)) return false;

        randomTeleport(player);

        return true;
    }

    void randomTeleport(Player player) {
        World world = player.getWorld();
        List<Location> able = new ArrayList<>();

        int checkX = (int) (Math.random() * 20001);
        int checkZ = (int) (Math.random() * 20001);

        for (int i = -64; i <= 320; i++) {
            Location location = new Location(world, checkX - 10000 + 0.5, i, checkZ - 10000 + 0.5);

            if (!isLiquid(location) && !isAIR(location)) {
                location.setY(i + 1);
                if (isAIR(location)) {
                    location.setY(i + 2);
                    if (isAIR(location)) {
                        able.add(location);
                    }
                }
            }
        }

        if (able.isEmpty()) {
            player.sendMessage("다시 하세요");
            return;
        }

        int size = able.size();
        int checkY = (int) (Math.random() * size);

        Location ableLocation = able.get(checkY);

        player.teleport(ableLocation);

    }

    boolean isLiquid(Location under) {
        Material getM = under.getBlock().getType();
        return getM == Material.WATER || getM == Material.LAVA;
    }

    boolean isAIR(Location under) {
        Material getM = under.getBlock().getType();
        return getM == Material.AIR || getM == Material.CAVE_AIR || getM == Material.VOID_AIR;
    }
}
