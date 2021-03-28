package de.sco.essential.commands;

import de.sco.essential.Essentials;
import de.sco.essential.util.BuildManager;
import de.sco.essential.util.Messages;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return false;
        }

        Player player = (Player) sender;
        BuildManager buildManager = Essentials.getInstance().getBuildManager();
        Messages msg = Essentials.getInstance().getMessages();

        if (args.length == 0) {
            if (player.hasPermission("essentials.build")) {
                if (buildManager.canBuild(player.getUniqueId().toString())) {
                    buildManager.setCanBuild(player.getUniqueId().toString(), false);
                    player.sendMessage(msg.getPrefix() + msg.getYouCantBuild());
                    return true;
                }
                buildManager.setCanBuild(player.getUniqueId().toString(), true);
                player.sendMessage(msg.getPrefix() + msg.getYouCanBuild());
                return true;
            }
            player.sendTitle("§5§lImmortal Objekt", "", 10, 60, 60);
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 5, 0);
            return true;
        }

        if (!player.hasPermission("essentials.manageWorldWhitelist")) {
            player.sendTitle("§5§lImmortal Objekt", "", 10, 60, 60);
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 5, 0);
            return true;
        }

        if (args.length == 1) {
            String worldName = player.getLocation().getWorld().getName();
            if (args[0].equalsIgnoreCase("add")) {
                if (buildManager.isOnWhitelist(worldName)) {
                    player.sendMessage(msg.getPrefix() + msg.getIsOnWhiteList().replace("%world%", worldName));
                    return true;
                }
                buildManager.addWorldToWhitelist(worldName);
                player.sendMessage(msg.getPrefix() + msg.getWorldAddedToWhitelist().replace("%world%", worldName));
                return true;
            }
            if (args[0].equalsIgnoreCase("remove")) {
                if (!buildManager.isOnWhitelist(worldName)) {
                    player.sendMessage(msg.getPrefix() + msg.getIsNotOnWhitelist().replace("%world%", worldName));
                    return true;
                }
                buildManager.removeWorldFrmWhitelist(worldName);
                player.sendMessage(msg.getPrefix() + msg.getRemovedFromWhitelist().replace("%world%", worldName));
                return true;
            }
            return true;
        }


        return false;
    }
}
