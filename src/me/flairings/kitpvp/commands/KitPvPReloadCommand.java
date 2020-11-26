package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class KitPvPReloadCommand implements CommandExecutor {

    public KitPvPReloadCommand(Main plugin) {
        plugin.getCommand("kitpvp-reload").setExecutor(this);
    }

    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("KitPvP");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        {
            if (!player.hasPermission("kitpvp.command.reload")) {
                player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
                return true;
            }
            plugin.reloadConfig();
            //plugin.getPluginLoader().disablePlugin(plugin); // CAUSES MULTI INSTANCES OF PLUGIN "KITPVP"
            //plugin.getPluginLoader().enablePlugin(plugin);
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("Reloaded-Message")));
        }
            return false;
        }
    }
