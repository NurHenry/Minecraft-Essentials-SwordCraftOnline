package de.sco.essential.listener;

import de.sco.essential.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitEventListener implements Listener {

    public PlayerQuitEventListener() {
        Essentials.getInstance().getServer().getPluginManager().registerEvents(this, Essentials.getInstance());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (Essentials.getInstance().getBuildManager().canBuild(event.getPlayer().getUniqueId().toString())) {
            Essentials.getInstance().getBuildManager().setCanBuild(event.getPlayer().getUniqueId().toString(), false);
        }
    }
}
