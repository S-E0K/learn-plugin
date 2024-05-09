package org.se0k.learnplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.se0k.learnplugin.command.LearnCommand;

public final class Learn_plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().warning("플러그인 활성화");

        Bukkit.getCommandMap().register("learn-plugin", new LearnCommand("test"));
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().warning("플러그인 비활성화");
    }
}
