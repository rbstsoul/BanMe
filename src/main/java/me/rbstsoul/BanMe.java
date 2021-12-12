package me.rbstsoul;

import me.rbstsoul.commands.Kick;
import me.rbstsoul.config.Config;
import me.rbstsoul.config.Messages;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BanMe extends JavaPlugin implements Listener {

    private static Config config = new Config();
    private static Messages messages = new Messages();

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String message(String message) {
        return color(messages.getMessagesConfiguration().getString("prefix") + " " + message);
    }

    @Override
    public void onEnable() {
        if (getConfig().getBoolean("enabled") == false) {
            getServer().getPluginManager().disablePlugin(this);
        } else {
            getLogger().info(color("&aEverything is perfect (for now)."));
            config.createConfig();
            messages.createMessages();
            this.getCommand("kick").setExecutor(new Kick());
            this.getCommand("kick").setTabCompleter(new TabCompleteKick());
            int pluginId = 13568;
            Metrics metrics = new Metrics(this, pluginId);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info(color("&cSo, that's the end? See you later!"));
    }
}
