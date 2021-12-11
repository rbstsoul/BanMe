package me.rbstsoul.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private File file;
    private FileConfiguration config;

    public void createConfig() {
        file = new File(Bukkit.getPluginManager().getPlugin("BanMe").getDataFolder(), "config.yml");

        if(!file.exists()) {
            file.getParentFile().mkdirs();
            Bukkit.getPluginManager().getPlugin("BanMe").saveResource("config.yml", false);
        }
        config = new YamlConfiguration();

        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public File getConfigFile() {
        return new File(Bukkit.getPluginManager().getPlugin("BanMe").getDataFolder(), "config.yml");
    }
    
    public FileConfiguration getConfigConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }
}
