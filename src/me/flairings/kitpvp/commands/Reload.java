package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Reload implements CommandExecutor {

    public Reload(Main plugin) {
        plugin.getCommand("kitpvp-reload").setExecutor(this);
    }

    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("KitPvP");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        {
            if (!player.hasPermission("kitpvp.command.reload")) {
                player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message").replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix"))))));
                return true;
            }
            plugin.reloadConfig();
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("Reloaded-Message").replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix"))))));
        }
            return false;
        }
    }
