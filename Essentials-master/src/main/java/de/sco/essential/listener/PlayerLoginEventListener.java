package de.sco.essential.listener;

import de.sco.essential.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLoginEventListener implements Listener {

    public PlayerLoginEventListener() {
        Essentials.getInstance().getServer().getPluginManager().registerEvents(this, Essentials.getInstance());
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event){
        if (Bukkit.getOnlinePlayers().size() >= Essentials.getInstance().getSystem().getMaxPlayers()){
            if (event.getPlayer().hasPermission("essentials.joinfull")){
                return;
            }
            event.disallow(PlayerLoginEvent.Result.KICK_FULL, Essentials.getInstance().getMessages().getPrefix() + "\n" + "§cDer Server ist voll, versuche es später nochmal");
        }
    }
}
