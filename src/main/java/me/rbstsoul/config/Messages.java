package me.rbstsoul.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {
    private File file;
    private FileConfiguration config;

    public void createMessages() {
        file = new File(Bukkit.getPluginManager().getPlugin("BanMe").getDataFolder(), "messages.yml");

        if(!file.exists()) {
            file.getParentFile().mkdirs();
            Bukkit.getPluginManager().getPlugin("BanMe").saveResource("messages.yml", false);
        }
        config = new YamlConfiguration();

        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public File getMessagesFile() {
        return new File(Bukkit.getPluginManager().getPlugin("BanMe").getDataFolder(), "messages.yml");
    }

    public FileConfiguration getMessagesConfiguration() {
        return YamlConfiguration.loadConfiguration(getMessagesFile());
    }
}
