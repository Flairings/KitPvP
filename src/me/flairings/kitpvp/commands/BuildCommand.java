package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    public BuildCommand() {
        Main.getInstance().getCommand("build").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("Player-Only-Message")));
        }
        if (!player.hasPermission("kitpvp.command.build")) {
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
            return true;
        }
        if (Main.playerlist.contains(player.getUniqueId())) {
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("Build-Disabled-Message")));
            Main.playerlist.remove(player.getUniqueId());
        } else {
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("Build-Enabled-Message")));
            Main.playerlist.add(player.getUniqueId());
        }
        return false;
    }

}
