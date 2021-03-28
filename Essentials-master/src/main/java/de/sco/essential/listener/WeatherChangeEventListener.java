package de.sco.essential.listener;

import de.sco.essential.Essentials;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherChangeEventListener implements Listener {

    public WeatherChangeEventListener() {
        Essentials.getInstance().getServer().getPluginManager().registerEvents(this, Essentials.getInstance());
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
