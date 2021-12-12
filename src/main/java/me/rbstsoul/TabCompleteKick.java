package me.rbstsoul;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteKick implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("kick")){
            if (sender.hasPermission("banme.command.kick")) {
                if (args.length == 1) {
                    return null;
                } else if (args.length == 2) {
                    List<String> reasons = new ArrayList<>();
                    reasons.add("Warning");
                    reasons.add("You can't do that");
                    reasons.add("Using bug");

                    return reasons;
                }
                List<String> empty = new ArrayList<>();
                return empty;
            } else if (!sender.hasPermission("banme.command.kick")){
                List<String> empty = new ArrayList<>();
                return empty;
            }
        }

        return null;
    }
}
