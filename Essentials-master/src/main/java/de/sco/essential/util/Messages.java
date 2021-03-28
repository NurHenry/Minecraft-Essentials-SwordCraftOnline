package de.sco.essential.util;

public class Messages {

    private final String Prefix = "§9[§b§lSwordCraftOnline§9]";
    private final String noPermissions = "§cKeine Rechte!";

    private final String gamemodeHelp = "§7/gm <0-3>";
    private final String ownGamemode = "§7Dein Spielmodus wurde auf §a%gamemode% §7gesetzt";
    private final String playerNotOnline = "§cDieser Spieler ist nicht online";
    private final String otherPlayerGamemode = "§7Dein Spielmodus wurde von §a%player% §7auf §a%gamemode% §7gesetzt";
    private final String otherPlayerGamemodeSet = "§7Der Spielmodus von §a%player% §7wurde auf §a%gamemode% §7gesetzt";

    private final String invSeeHelp = "§7/invsee <Spielername>";

    private final String youCanBuild = "§7Dein Baumodus wurde §aaktiviert";
    private final String youCantBuild = "§7Dein Baumodus wurde §cdeaktiviert";
    private final String worldAddedToWhitelist = "§7Die Welt §a%world% §7Wurde zur Whitelist hinzugefügt";
    private final String isOnWhiteList = "§7Die Welt §a%world% §7Befindet sich auf der Whitelist";
    private final String isNotOnWhitelist = "§cDie Welt §a%world% §7ist nicht auf der Whitelist";
    private final String removedFromWhitelist = "§7Die Welt §a%world%§7 wurde von der Whitelist entfernt";
    private final String buildHelp = "§7Benutze §a/build §7um zu Bauen!";

    private final String msgHelp = "§7/msg <playername>";

    private final String maxPlayerHelp = "§7/slotsr <anzahl/reload>";
    private final String maxPlayerSet = "§7Du hast die Spielerzahl auf §a%maxplayer% §7gesetzt";
    private final String maxPlayerCantSet = "§cFehler beim setzen der max Player, hast du eine gültige Zahl angegeben?";
    private final String maxPlayerReload = "§7Config reloaded";

    private final String pluginLookup = "§7Ein Server auf basis von Swort art Online";

    public Messages() {
    }

    public String getPrefix() {
        return Prefix;
    }

    public String getNoPermissions() {
        return noPermissions;
    }

    public String getGamemodeHelp() {
        return gamemodeHelp;
    }

    public String getOwnGamemode() {
        return ownGamemode;
    }

    public String getPlayerNotOnline() {
        return playerNotOnline;
    }

    public String getOtherPlayerGamemode() {
        return otherPlayerGamemode;
    }

    public String getOtherPlayerGamemodeSet() {
        return otherPlayerGamemodeSet;
    }

    public String getInvSeeHelp() {
        return invSeeHelp;
    }

    public String getYouCanBuild() {
        return youCanBuild;
    }

    public String getYouCantBuild() {
        return youCantBuild;
    }

    public String getWorldAddedToWhitelist() {
        return worldAddedToWhitelist;
    }

    public String getRemovedFromWhitelist() {
        return removedFromWhitelist;
    }

    public String getIsOnWhiteList() {
        return isOnWhiteList;
    }

    public String getIsNotOnWhitelist() {
        return isNotOnWhitelist;
    }

    public String getMsgHelp() {
        return msgHelp;
    }

    public String getBuildHelp() {
        return buildHelp;
    }

    public String getMaxPlayerHelp() {
        return maxPlayerHelp;
    }

    public String getMaxPlayerSet() {
        return maxPlayerSet;
    }

    public String getMaxPlayerCantSet() {
        return maxPlayerCantSet;
    }

    public String getMaxPlayerReload() {
        return maxPlayerReload;
    }

    public String getPluginLookup() {
        return pluginLookup;
    }
}
