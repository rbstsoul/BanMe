package me.rbstsoul.commands;

import me.rbstsoul.BanMe;
import me.rbstsoul.config.Config;
import me.rbstsoul.config.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kick implements CommandExecutor {

    private static Config config = new Config();
    private static Messages messages = new Messages();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kick")) {
            if (sender.hasPermission("banme.command.kick")) {
                if (args.length == 0) {
                    sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("no-player")));
                } else if (args.length == 1) {
                    Player kicked = (Bukkit.getServer().getPlayer(args[0]));
                    if (kicked == null) {
                        sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("player-offline")));
                    } else if (kicked == sender){
                        sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("dont-write-yourself")));
                    } else {
                        kicked.kickPlayer(BanMe.color(messages.getMessagesConfiguration().getString("kick-message").replace("%admin%", sender.getName()).replace("%reason%", messages.getMessagesConfiguration().getString("default-reason"))));
                        sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("kicked").replace("%player%", kicked.getName())));
                    }
                } else if (args.length >= 2) {
                    StringBuilder sb = new StringBuilder();
                    Player kicked = (Bukkit.getServer().getPlayer(args[0]));
                    if (kicked == null) {
                        sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("player-offline")));
                    } else if (kicked == sender){
                        sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("dont-write-yourself")));
                    } else {
                        for (int i = 1; i < args.length; i++){
                            sb.append(args[i]).append(" ");
                        }
                        String reason = sb.toString().trim();
                        kicked.kickPlayer(BanMe.color(messages.getMessagesConfiguration().getString("kick-message").replace("%admin%", sender.getName()).replace("%reason%", reason)));
                        sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("kicked").replace("%player%", kicked.getName())));
                    }
                }
            } else {
                sender.sendMessage(BanMe.message(messages.getMessagesConfiguration().getString("no-permission")));
            }
            return true;
        }

        return true;
    }
}
