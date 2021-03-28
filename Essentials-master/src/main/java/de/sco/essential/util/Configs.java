package de.sco.essential.util;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Configs {

    private File file = new File("./Plugins/Essentials", "config.yml");
    private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public void setCfg(FileConfiguration cfg) {
        this.cfg = cfg;
    }

    public void set(String path, Object object){
        cfg.set(path, object);

        try {
            cfg.save(file);
            Bukkit.broadcastMessage("saved");
        } catch (IOException e) {
            Bukkit.broadcastMessage("not saved");
            e.printStackTrace();
        }
    }

    public String getString(String path){
        return cfg.getString(path);
    }

    public List<String> getStringList(String path){
        return cfg.getStringList(path);
    }

    public boolean getBoolean(String path){
        return cfg.getBoolean(path);
    }

    public int getInteger(String path){
        return cfg.getInt(path);
    }

    public double getDouble(String path){
        return cfg.getDouble(path);
    }

    public float getFloat(String path){
        return (float) cfg.get(path);
    }

    public long getLong(String path){
        return cfg.getLong(path);
    }

    public boolean isInConfig(String path){
        try {
            if (cfg.get(path) != null){
                return true;
            }
        }catch (Exception ex){
            return false;
        }

        return false;
    }
}
