package de.sco.essential;

import de.sco.essential.commands.*;
import de.sco.essential.commands.tabComplete.GamemodeTabComplete;
import de.sco.essential.commands.tabComplete.InvSeeTabComplete;
import de.sco.essential.commands.tabComplete.MSGTabComplete;
import de.sco.essential.listener.*;
import de.sco.essential.util.*;
import de.sco.essential.util.System;
import org.bukkit.plugin.java.JavaPlugin;

public class Essentials extends JavaPlugin {


    private static Essentials instance;
    private Messages messages;
    private BuildManager buildManager;
    private System system;
    private Configs configs;
    private AntiCheat antiCheat;

    public static Essentials getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        this.configs = new Configs();
        this.messages = new Messages();
        this.buildManager = new BuildManager();
        this.system = new System();
        this.antiCheat = new AntiCheat();

        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("gm").setTabCompleter(new GamemodeTabComplete());

        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gamemode").setTabCompleter(new GamemodeTabComplete());

        getCommand("invsee").setExecutor(new InvSeeCommand());
        getCommand("invsee").setTabCompleter(new InvSeeTabComplete());

        getCommand("build").setExecutor(new BuildCommand());

        getCommand("msg").setExecutor(new MSGCommand());
        getCommand("msg").setTabCompleter(new MSGTabComplete());

        getCommand("tell").setExecutor(new MSGCommand());
        getCommand("tell").setTabCompleter(new MSGTabComplete());

        getCommand("r").setExecutor(new MSGCommand());
        getCommand("r").setTabCompleter(new MSGTabComplete());

        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("ec").setExecutor(new EnderChestCommand());

        getCommand("slots").setExecutor(new SlotsCommand());

        getCommand("pl").setExecutor(new PluginCommand());
        getCommand("plugins").setExecutor(new PluginCommand());
        getCommand("help").setExecutor(new PluginCommand());
        getCommand("?").setExecutor(new PluginCommand());

        new BuildListener();
        new PlayerQuitEventListener();
        new WeatherChangeEventListener();
        new PlayerLoginEventListener();
        new ServerListPingEventListener();


    }

    public Messages getMessages() {
        return messages;
    }

    public BuildManager getBuildManager() {
        return buildManager;
    }

    public System getSystem() {
        return system;
    }

    public Configs getConfigs() {
        return configs;
    }

    public AntiCheat getAntiCheat() {
        return antiCheat;
    }
}
