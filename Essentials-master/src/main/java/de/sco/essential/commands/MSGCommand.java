package de.sco.essential.commands;

import de.sco.essential.Essentials;
import de.sco.essential.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        Messages messages = Essentials.getInstance().getMessages();

        if (args.length == 0 || args.length == 1) {
            player.sendMessage(messages.getPrefix() + messages.getMsgHelp());
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (!Bukkit.getOnlinePlayers().contains(target)) {
            player.sendMessage(messages.getPrefix() + messages.getPlayerNotOnline());
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < args.length; i++) {
            stringBuilder.append(args[i] + " ");
        }

        player.sendMessage("§9[§bme §7 -> §b" + target.getName() + "§9]§7 " + stringBuilder.toString());
        target.sendMessage("§9[§b" + player.getName() + " §7 -> §bme§9]§7 " + stringBuilder.toString());


        return false;
    }
}
