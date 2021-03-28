package de.sco.essential.listener;

import de.sco.essential.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingEventListener implements Listener {

    public ServerListPingEventListener() {
        Essentials.getInstance().getServer().getPluginManager().registerEvents(this, Essentials.getInstance());
    }

    @EventHandler
    public void onPing(ServerListPingEvent event){
        event.setMaxPlayers(Essentials.getInstance().getSystem().getMaxPlayers());
        event.setMotd(Essentials.getInstance().getSystem().getMotd1() + "\n" + Essentials.getInstance().getSystem().getMotd2());
    }
}
