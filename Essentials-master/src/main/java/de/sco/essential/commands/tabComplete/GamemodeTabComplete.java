package de.sco.essential.commands.tabComplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamemodeTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (!(sender instanceof Player)) {
            return null;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("essentials.gamemode")) {
            return null;
        }

        if (args.length == 1) {
            return Arrays.asList("survival", "creative", "adventure", "spectator");
        }

        if (args.length == 2) {
            List<String> players = new ArrayList<>();

            for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {
                players.add(onlinePlayers.getName());
            }

            return players;
        }
        return null;
    }
}
