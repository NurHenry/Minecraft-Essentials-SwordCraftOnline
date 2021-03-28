package de.sco.essential.commands;

import de.sco.essential.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PluginCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)){
            return false;
        }

        Player player = (Player) commandSender;

        if (!player.hasPermission("essential.seeplugins")){
            player.sendMessage(Essentials.getInstance().getMessages().getPrefix() + Essentials.getInstance().getMessages().getPluginLookup());
            return true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("§a");

        for (Plugin plugin: Bukkit.getServer().getPluginManager().getPlugins()) {
            if (plugin.isEnabled()){
                stringBuilder.append("§a" + plugin.getName() + "§a, ");
            }else {
                stringBuilder.append("§c" + plugin.getName() + "§a, ");
            }
        }

        player.sendMessage(stringBuilder.toString());
        return false;
    }
}
