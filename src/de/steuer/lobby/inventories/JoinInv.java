package de.steuer.lobby.inventories;

import de.steuer.lobby.utils.ItemAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class JoinInv {

    public static void GetJoinItems(Player p) {
        p.getInventory().setItem(0, new ItemAPI(Material.COMPASS).setName("§a§lNavigator").build());
        p.getInventory().setItem(1, new ItemAPI(Material.STICK).setName("§c§lSpieler verstecken").build());
        p.getInventory().setItem(4, new ItemAPI(Material.BARRIER).setName("§c§lKein Gadget ausgewählt").build());
        p.getInventory().setItem(7, new ItemAPI(Material.CHEST).setName("§a§lGadgets").build());
        p.getInventory().setItem(8, new ItemAPI(Material.SKULL_ITEM).setName("§a§lDein Profil").build());
    }
}
