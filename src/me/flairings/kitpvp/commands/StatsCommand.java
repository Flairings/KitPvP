package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {

    public StatsCommand(Main plugin) {
        plugin.getCommand("stats").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (!player.hasPermission("kitpvp.command.stats")) {
            player.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
            return true;
        }
        if (args.length == 0) {
            Main.getInstance().getConfig().getStringList("stats.message").forEach(string -> sender.sendMessage(CC.translate(string)
                    .replace("{KILLS}", "" + player.getStatistic(Statistic.PLAYER_KILLS))
                    .replace("{DEATHS}", "" + player.getStatistic(Statistic.DEATHS))));
        } else {
            Player target = Bukkit.getPlayer(args[0]);
            Main.getInstance().getConfig().getStringList("stats-other.message").forEach(string -> sender.sendMessage(CC.translate(string)
                    .replace("{PLAYER}", "" + target.getDisplayName())
                    .replace("{KILLS}", "" + target.getStatistic(Statistic.PLAYER_KILLS))
                    .replace("{DEATHS}", "" + target.getStatistic(Statistic.DEATHS))));
        }
        return false;
    }
}
