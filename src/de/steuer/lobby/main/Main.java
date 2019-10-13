package de.steuer.lobby.main;

import de.steuer.lobby.commands.buildCMD;
import de.steuer.lobby.listener.JoinListener;
import de.steuer.lobby.listener.ProtectionListener;
import de.steuer.lobby.listener.QuitListener;
import de.steuer.lobby.listener.SneakListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {

    public static Main plugin;
    public static List<Player> build = new ArrayList<>();
    public static String prefix = "§8| §a§lLOBBY §r§8| §r";
    public static String noperms = prefix + "§7Dazu hast du keine Rechte.";
    public static String notfound = prefix + "§7Dieser Spieler wurde nicht gefunden.";

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(prefix + "§7Das Lobbyplugin wurde erfolgreich gestartet");

        //LISTENER
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new SneakListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectionListener(), this);
        //COMMANDS
        getCommand("build").setExecutor(new buildCMD());


        loadconfig();
    }

    private void loadconfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static Main getPlugin() {
        return plugin;
    }
}
