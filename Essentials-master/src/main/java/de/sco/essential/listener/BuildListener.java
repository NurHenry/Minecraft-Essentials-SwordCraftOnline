package de.sco.essential.listener;

import de.sco.essential.Essentials;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildListener implements Listener {

    public BuildListener() {
        Essentials.getInstance().getServer().getPluginManager().registerEvents(this, Essentials.getInstance());
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        if (Essentials.getInstance().getBuildManager().isOnWhitelist(event.getPlayer().getLocation().getWorld().getName()) || Essentials.getInstance().getBuildManager().canBuild(event.getPlayer().getUniqueId().toString())) {
            return;
        }
        Player player = event.getPlayer();

        if (player.hasPermission("essentials.build")) {
            player.sendMessage(Essentials.getInstance().getMessages().getPrefix() + Essentials.getInstance().getMessages().getBuildHelp());
        }else {
            player.sendTitle("§5§lImmortal Objekt", "", 10, 60, 60);
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 5, 0);
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreake(BlockBreakEvent event) {

        if (Essentials.getInstance().getBuildManager().isOnWhitelist(event.getPlayer().getLocation().getWorld().getName()) || Essentials.getInstance().getBuildManager().canBuild(event.getPlayer().getUniqueId().toString())) {
            return;
        }

        Player player = event.getPlayer();

        if (player.hasPermission("essentials.build")) {
            player.sendMessage(Essentials.getInstance().getMessages().getPrefix() + Essentials.getInstance().getMessages().getBuildHelp());
        }else {
            player.sendTitle("§5§lImmortal Objekt", "", 10, 60, 60);
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 5, 0);
        }

        event.setCancelled(true);
    }
}
