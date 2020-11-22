package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayer;

public class HowToPlayCommand implements CommandExecutor {
    public HowToPlayCommand(Main plugin) {
        plugin.getCommand("howtoplay").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length < 1) {
            if (!player.hasPermission("kitpvp.command.howtoplay")) {
                player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message").replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix"))))));
                return true;
            } else {
                Main.howToPlayUI.open(player);
                return false;
            }
        } else {
            Player target = getPlayer(args[0]);
            if (target.isOnline()) {
                Main.howToPlayUI.open(target);
                return true;
            }
        }
        return true;
    }
}
