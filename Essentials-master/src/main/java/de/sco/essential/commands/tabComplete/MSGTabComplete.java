package de.sco.essential.commands.tabComplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MSGTabComplete implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }


        if (args.length == 1) {
            List<String> players = new ArrayList<>();

            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                players.add(onlinePlayers.getName());
            }

            return players;
        }
        return null;
    }
}
