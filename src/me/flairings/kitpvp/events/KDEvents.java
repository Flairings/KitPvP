package me.flairings.kitpvp.events;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KDEvents implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        if (player.isDead() && player.getKiller() != null) {
            killer.giveExpLevels(Main.getInstance().getConfig().getInt("kd-events.xp-amount"));
            Main.getInstance().getConfig().getStringList("kd-events.commands").forEach(string -> Bukkit.dispatchCommand(console, (CC.translate(string)
                    .replace("{KILLER}", "" + killer.getName())
                    .replace("{VICTIM}", "" + player.getName()))));
            }
            if (Main.getInstance().getConfig().getBoolean("kd-events.kill-sound-enabled")) {
                player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 2F, 1F);
            }
            Main.getInstance().getConfig().getStringList("kd-events.killer-messages").forEach(string -> killer.sendMessage(CC.translate(string)
                    .replace("{KILLER}", "" + killer.getName())
                    .replace("{VICTIM}", "" + player.getName())));

            Main.getInstance().getConfig().getStringList("kd-events.victim-messages").forEach(string -> player.sendMessage(CC.translate(string)
                    .replace("{KILLER}", "" + killer.getName())
                    .replace("{VICTIM}", "" + player.getName())));

            if(player.getKiller() instanceof Player) {
                Bukkit.getServer().broadcastMessage(CC.translate(Main.getInstance().getConfig().getString("kd-events.kill-message"))
                        .replace("{KILLER}", "" + killer.getName())
                        .replace("{VICTIM}", "" + player.getName()));
            } else {
                Bukkit.getServer().broadcastMessage(CC.translate(Main.getInstance().getConfig().getString("kd-events.death-message"))
                        .replace("{VICTIM}", "" + player.getName()));
            }
        }
    }
