package de.steuer.lobby.listener;

import de.steuer.lobby.main.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String msg = Main.getPlugin().getConfig().getString("Lobby.LeaveMessage");
        msg = msg.replaceAll("&", "§");
        msg = msg.replace("%player%", p.getName());
        e.setQuitMessage(msg);
    }
}
