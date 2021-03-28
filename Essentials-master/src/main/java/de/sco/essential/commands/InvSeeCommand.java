package de.sco.essential.commands;

import de.sco.essential.Essentials;
import de.sco.essential.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        Messages messages = Essentials.getInstance().getMessages();

        if (!player.hasPermission("essentials.invsee")) {
            player.sendMessage(messages.getPrefix() + messages.getNoPermissions());
            return true;
        }

        if (args.length == 0 || args.length >= 2) {
            player.sendMessage(messages.getPrefix() + messages.getInvSeeHelp());
            return true;
        }

        if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[0]))) {
            Player target = Bukkit.getPlayer(args[0]);
            player.openInventory(target.getInventory());
            return true;
        }

        player.sendMessage(messages.getPrefix() + messages.getPlayerNotOnline());

        return false;
    }
}
