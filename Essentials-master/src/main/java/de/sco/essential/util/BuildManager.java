package de.sco.essential.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuildManager {

    private List<String> worldWhitelist = new ArrayList<>();
    private final List<String> buildPlayers = new ArrayList<>();
    private final File worldFile = new File("./Plugins/Essentials", "worlds.yml");
    private final FileConfiguration worldCFG = YamlConfiguration.loadConfiguration(worldFile);

    public BuildManager() {
        this.worldWhitelist = worldCFG.getStringList("worlds");
    }

    public boolean isOnWhitelist(String worldName) {
        return worldWhitelist.contains(worldName);
    }

    public void addWorldToWhitelist(String name) {

        worldWhitelist.add(name);

        worldCFG.set("worlds", worldWhitelist);
        try {
            worldCFG.save(worldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeWorldFrmWhitelist(String name) {

        worldWhitelist.remove(name);

        worldCFG.set("worlds", worldWhitelist);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getLocation().getWorld().getName() == name) {
                buildPlayers.remove(player.getUniqueId().toString());
            }
        }

        try {
            worldCFG.save(worldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean canBuild(String UUID) {
        return buildPlayers.contains(UUID);
    }

    public void setCanBuild(String UUID, boolean action) {
        if (action) {
            this.buildPlayers.add(UUID);
            return;
        }
        this.buildPlayers.remove(UUID);
    }


}
