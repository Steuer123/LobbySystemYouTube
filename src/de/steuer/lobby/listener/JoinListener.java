package de.steuer.lobby.listener;

import de.steuer.lobby.inventories.JoinInv;
import de.steuer.lobby.main.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(Main.build.contains(p)) {
            Main.build.remove(p);
        }

        String msg = Main.getPlugin().getConfig().getString("Lobby.JoinMessage");
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setJoinMessage(msg);

        p.setGameMode(GameMode.SURVIVAL);
        p.getInventory().clear();
        JoinInv.GetJoinItems(p);

    }
}
