package de.sco.essential.commands;

import de.sco.essential.Essentials;
import de.sco.essential.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        Messages messages = Essentials.getInstance().getMessages();

        player.openInventory(player.getEnderChest());

        if (args.length == 1){
            if (!player.hasPermission("essentials.seeenderchest")){
                player.sendMessage(messages.getPrefix() + messages.getNoPermissions());
                return true;
            }

            Player target = Bukkit.getPlayer(args[0]);

            player.openInventory(target.getEnderChest());
        }
        return false;
    }
}
