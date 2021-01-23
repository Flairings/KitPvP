package me.flairings.kitpvp.events;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;


public class BlockEvents implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!Main.playerlist.contains(p.getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage(CC.translate(Main.getInstance().getConfig().getString("OnBlockPlace-Message")));
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (!Main.playerlist.contains(p.getUniqueId())) {
            e.setCancelled(true);
            p.sendMessage(CC.translate(Main.getInstance().getConfig().getString("OnBlockBreak-Message")));
        } else {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Main.playerlist.remove(p.getUniqueId());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!Main.playerlist.contains(player.getUniqueId())) {
            Main.playerlist.add(player.getUniqueId());
        }
    }
}

