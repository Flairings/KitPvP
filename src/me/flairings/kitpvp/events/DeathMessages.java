package me.flairings.kitpvp.events;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessages implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        Player killer = player.getKiller();
        if (player.isDead() && player.getKiller() instanceof Player) {
            Bukkit.getServer().broadcastMessage(CC.translate(Main.getInstance().getConfig().getString("player-kill-player-message"))
                    .replace("{KILLER}", "" + killer.getName())
                    .replace("{VICTIM}", "" + player.getName())
                    .replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix")))));
        }else{
                Bukkit.getServer().broadcastMessage(CC.translate(Main.getInstance().getConfig().getString("death-message"))
                        .replace("{VICTIM}", "" + player.getName())
                        .replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix")))));

            }
        }
    }
