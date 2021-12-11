package me.rbstsoul;

import me.rbstsoul.config.Config;
import me.rbstsoul.config.Messages;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanMe extends JavaPlugin implements Listener {

    private Config Config = new Config();
    private Messages Messages = new Messages();


    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    @Override
    public void onEnable() {
        if (getConfig().getBoolean("enabled") == false) {
            getServer().getPluginManager().disablePlugin(this);
        } else {
            getLogger().info(color("&aEverything is perfect (for now)."));
            Config.createConfig();
            Messages.createMessages();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(color("&cSo, that's the end? See you later!"));
    }
}
