package me.flairings.kitpvp;

import me.flairings.kitpvp.api.InventoryHandler;
import me.flairings.kitpvp.api.UtilConfig;
import me.flairings.kitpvp.commands.*;
import me.flairings.kitpvp.events.BlockEvents;
import me.flairings.kitpvp.events.DeathEvent;
import me.flairings.kitpvp.events.JoinEvents;
import me.flairings.kitpvp.events.KillRewardsEvent;
import me.flairings.kitpvp.scoreboard.Scoreboard;
import me.flairings.kitpvp.scoreboard.api.Assemble;
import me.flairings.kitpvp.scoreboard.api.AssembleStyle;
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
        loadScoreboard();
        loadEngine();
        loadEvents();
        loadCommands();
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7-------------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("          &6KitPvP &fhas been &aenabled"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&7-------------------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&6&lKitPvP &7| &f" + Main.getInstance().getDescription().getPermissions().size() + " &6permissions have been registered."));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&6&lKitPvP &7| &f" + Main.getInstance().getDescription().getCommands().size() + " &6commands have been registered."));

    }
    public void loadEngine() {
        instance = this;
        playerlist = new ArrayList<>();
        inventoryHandler = new InventoryHandler().init();
        howToPlayUI = new HowToPlayUI();
        this.createYML();
    }

    public void loadScoreboard() {
        Assemble assemble = new Assemble(this, new Scoreboard());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);
    }

    public void loadCommands() {
        // staff commands
        new BuildCommand();
        new KitPvPCommand(this);

        // management commands
        new ReloadCommand(this);

        // essential commands
        new StatsCommand(this);
        new KillRewardsCommand(this);
        new HowToPlayCommand(this);

        // profile commands
        new ProfileCommand(this);
    }

    public void loadEvents() {
        PluginManager pm = getPluginManager();
        pm.registerEvents(new KillRewardsEvent(), this);
        pm.registerEvents(new BlockEvents(), this);
        pm.registerEvents(new DeathEvent(), this);
        pm.registerEvents(new JoinEvents(), this);
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