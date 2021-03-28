package de.sco.essential.commands;

import de.sco.essential.Essentials;
import de.sco.essential.util.Messages;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;
        Messages messages = Essentials.getInstance().getMessages();

        if (!player.hasPermission("essentials.gamemode")) {
            player.sendMessage(messages.getPrefix() + messages.getNoPermissions());
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(messages.getPrefix() + messages.getGamemodeHelp());
            return true;
        }

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(messages.getPrefix() + messages.getOwnGamemode().replace("%gamemode%", player.getGameMode().toString()));
                Essentials.getInstance().getAntiCheat().setGame(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(messages.getPrefix() + messages.getOwnGamemode().replace("%gamemode%", player.getGameMode().toString()));
                Essentials.getInstance().getAntiCheat().setNoGame(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(messages.getPrefix() + messages.getOwnGamemode().replace("%gamemode%", player.getGameMode().toString()));
                Essentials.getInstance().getAntiCheat().setNoGame(player);
                return true;
            }
            if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(messages.getPrefix() + messages.getOwnGamemode().replace("%gamemode%", player.getGameMode().toString()));
                Essentials.getInstance().getAntiCheat().setNoGame(player);
                return true;
            }
            player.sendMessage(messages.getPrefix() + messages.getGamemodeHelp());
        }

        if (args.length == 2) {
            if (!player.hasPermission("essentials.gamemode.other")) {
                player.sendMessage(messages.getPrefix() + messages.getNoPermissions());
                return true;
            }
            if (!Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(args[1]))) {
                player.sendMessage(messages.getPrefix() + messages.getPlayerNotOnline());
            }
            Player target = Bukkit.getPlayer(args[1]);

            if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                target.setGameMode(GameMode.SURVIVAL);
                Essentials.getInstance().getAntiCheat().setGame(target);
            }
            if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                target.setGameMode(GameMode.CREATIVE);
                Essentials.getInstance().getAntiCheat().setNoGame(target);
            }
            if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                target.setGameMode(GameMode.ADVENTURE);
                Essentials.getInstance().getAntiCheat().setNoGame(target);
            }
            if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                target.setGameMode(GameMode.SPECTATOR);
                Essentials.getInstance().getAntiCheat().setNoGame(target);
            }

            target.sendMessage(messages.getPrefix() + messages.getOtherPlayerGamemode().replace("%player%", player.getName()).replace("%gamemode%", target.getGameMode().toString()));
            player.sendMessage(messages.getPrefix() + messages.getOtherPlayerGamemodeSet().replace("%player%", target.getName()).replace("%gamemode%", target.getGameMode().toString()));
            return true;
        }
        player.sendMessage(messages.getPrefix() + messages.getGamemodeHelp());
        return true;
    }


}
