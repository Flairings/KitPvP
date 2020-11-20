package me.flairings.kitpvp;

import me.flairings.kitpvp.api.InventoryHandler;
import me.flairings.kitpvp.api.UtilConfig;
import me.flairings.kitpvp.commands.*;
import me.flairings.kitpvp.events.BlockEvents;
import me.flairings.kitpvp.events.KillRewardsEvent;
import me.flairings.kitpvp.ui.HowToPlayUI;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Bukkit.getPluginManager;

public class Main extends JavaPlugin {
    public static UtilConfig settings;
    public static HowToPlayUI howToPlayUI;
    public static Main instance;
    public static List<UUID> playerlist;
    private static InventoryHandler inventoryHandler;

    public static InventoryHandler getInventoryHandler() {
        return Main.inventoryHandler;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        playerlist = new ArrayList<>();
        inventoryHandler = new InventoryHandler().init();
        howToPlayUI = new HowToPlayUI();
        this.createYML();
        EventRegister();
        CommandRegister();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7-------------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("          &6KitPvP &fhas been &aenabled"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7-------------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&6&lKitPvP &7| &f" + Main.getInstance().getDescription().getPermissions().size() + " &6permissions have been registered."));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&6&lKitPvP &7| &f" + Main.getInstance().getDescription().getCommands().size() + " &6commands have been registered."));

    }

    public void CommandRegister() {
        new Build();
        new Reload(this);
        new KitPvP(this);
        new Stats(this);
        new KillRewards(this);
        new HowToPlay(this);
    }

    public void EventRegister() {
        PluginManager pm = getPluginManager();
        pm.registerEvents(new KillRewardsEvent(), this);
        pm.registerEvents(new BlockEvents(), this);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7-------------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("          &6KitPvP &fhas been &cdisabled"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7-------------------------------------------"));
    }

    public void createYML() {
        settings = new UtilConfig(this, "config.yml", null);
        settings.saveDefaultConfig();
    }
}