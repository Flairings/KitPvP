package me.flairings.kitpvp.events;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvents implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Main.getInstance().getConfig().getStringList("join-events.messages").forEach(string -> player.sendMessage(CC.translate(string)
                .replace("{PLAYER}", "" + player.getName())
                .replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix"))))));
        if (Main.getInstance().getConfig().getBoolean("join-events.sound-enabled")) {
            player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 2F, 1F);
        }
    }
}
