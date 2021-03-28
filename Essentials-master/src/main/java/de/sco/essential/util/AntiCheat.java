package de.sco.essential.util;

import de.sco.essential.Essentials;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.HashMap;

public class AntiCheat implements Listener {

    private HashMap<String, ItemStack[]> inventorys = new HashMap<>();
    private HashMap<String, ItemStack[]> armor = new HashMap<>();

    public AntiCheat() {
        Essentials.getInstance().getServer().getPluginManager().registerEvents(this, Essentials.getInstance());
    }

    public void setNoGame(Player player){
        if (inventorys.containsKey(player.getUniqueId().toString())){
            return;
        }
        armor.put(player.getUniqueId().toString(), player.getInventory().getArmorContents());
        inventorys.put(player.getUniqueId().toString(), player.getInventory().getContents());
    }

    public void setGame(Player player){
        if (!inventorys.containsKey(player.getUniqueId().toString())){
            return;
        }
        player.getInventory().setContents(inventorys.get(player.getUniqueId().toString()));
        player.getInventory().setArmorContents(armor.get(player.getUniqueId().toString()));

        inventorys.remove(player.getUniqueId().toString());
        armor.remove(player.getUniqueId().toString());

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event){
        if (!(event.getPlayer().getGameMode() == GameMode.SURVIVAL)){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void openEnderChest(PlayerInteractEvent event){
        if (event.getPlayer().getGameMode() == GameMode.SURVIVAL){
            return;
        }

        if (event.getClickedBlock().getType() == Material.ENDER_CHEST){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.CHEST){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.CHEST_MINECART){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.TRAPPED_CHEST){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.BARREL){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.FURNACE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.FURNACE_MINECART){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.BLAST_FURNACE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.SMOKER){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.CARTOGRAPHY_TABLE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.FLETCHING_TABLE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.GRINDSTONE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.SMITHING_TABLE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.STONECUTTER){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.LOOM){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.ENCHANTING_TABLE){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.ANVIL){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.CHIPPED_ANVIL){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.DAMAGED_ANVIL){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.WHITE_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.ORANGE_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.MAGENTA_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.LIGHT_BLUE_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.YELLOW_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.LIME_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.PINK_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.GRAY_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.LIGHT_GRAY_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.CYAN_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.PURPLE_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.BLUE_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.BROWN_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.GREEN_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.RED_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.BLACK_SHULKER_BOX){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.DROPPER){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.DISPENSER){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.HOPPER){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
        if (event.getClickedBlock().getType() == Material.HOPPER_MINECART){
            event.setCancelled(true);
            event.getPlayer().closeInventory();
            return;
        }
    }
}
