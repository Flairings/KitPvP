package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillRewards implements CommandExecutor {

    public KillRewards(Main plugin) {
        plugin.getCommand("killrewards").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (player.hasPermission("kitpvp.command.killrewards")) {
            Main.getInstance().getConfig().getStringList("kill-rewards-help.message").forEach(string -> sender.sendMessage(CC.translate(string)
                    .replace("{XP}", "" + Main.getInstance().getConfig().getInt("kill-rewards.xp-amount"))
                    .replace("{CMDs}", "" + Main.getInstance().getConfig().getStringList("kill-rewards.commands"))));
            return true;
        } else {
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message").replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix"))))));
            return false;
        }
    }
}