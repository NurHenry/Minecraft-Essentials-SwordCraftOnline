package de.sco.essential.util;

import de.sco.essential.Essentials;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class System {

    private int maxPlayers;
    private String motd1;
    private String motd2;

    private Configs configs;

    public System() {
        this.configs = Essentials.getInstance().getConfigs();
        if (!this.configs.isInConfig("system.motd1")){
            this.configs.set("system.motd1", "&aSet Line 1 in the config.yml");
            this.configs.set("system.motd2", "&7Set Line 2 in the config.yml");
            this.configs.set("system.maxPlayer", 20);
        }

        this.motd1 = this.configs.getString("system.motd1").replace("&", "§");
        this.motd2 = this.configs.getString("system.motd2").replace("&", "§");
        this.maxPlayers = this.configs.getInteger("system.maxPlayer");

    }

    public void reload(){
        this.motd1 = this.configs.getString("system.motd1").replace("&", "§");
        this.motd2 = this.configs.getString("system.motd2").replace("&", "§");
        this.maxPlayers = this.configs.getInteger("system.maxPlayer");
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;

        this.configs.set("system.maxPlayer", maxPlayers);
    }

    public String getMotd1() {
        return motd1;
    }

    public void setMotd1(String motd1) {
        this.motd1 = motd1;
    }

    public String getMotd2() {
        return motd2;
    }

    public void setMotd2(String motd2) {
        this.motd2 = motd2;
    }
}
