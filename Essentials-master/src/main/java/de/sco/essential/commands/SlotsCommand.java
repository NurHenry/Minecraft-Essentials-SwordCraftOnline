package de.sco.essential.commands;

import de.sco.essential.Essentials;
import de.sco.essential.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlotsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (!(commandSender instanceof Player)) {
            return false;
        }

        Player player = (Player) commandSender;
        Messages messages = Essentials.getInstance().getMessages();

        if (!player.hasPermission("essentials.slots")){
            player.sendMessage(messages.getPrefix() + messages.getNoPermissions());
            return true;
        }

        if (args.length == 0){
            player.sendMessage(messages.getPrefix() + messages.getMaxPlayerHelp());
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")){
            Essentials.getInstance().getSystem().reload();
            player.sendMessage(messages.getPrefix() + messages.getMaxPlayerReload());
            return true;
        }

        int max = 0;

        try {
            max = Integer.valueOf(args[0]);
            player.sendMessage(messages.getPrefix() + messages.getMaxPlayerSet().replace("%maxplayer%", "" + max));
        }catch (Exception ex){
            player.sendMessage(messages.getPrefix() + messages.getMaxPlayerCantSet());
            max = Bukkit.getMaxPlayers();
        }

        Essentials.getInstance().getSystem().setMaxPlayers(max);

        return false;
    }
}
