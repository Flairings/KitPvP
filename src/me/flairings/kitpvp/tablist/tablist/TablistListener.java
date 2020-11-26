package me.flairings.kitpvp.tablist.tablist;

import me.flairings.kitpvp.tablist.Poseidon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;

public final class TablistListener implements Listener {

    public TablistListener() {
        Poseidon.getInstance().getPlugin().getServer().getPluginManager().registerEvents(this, Poseidon.getInstance().getPlugin());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Poseidon.getInstance().getTablistManager().addTablist(event.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Poseidon.getInstance().getTablistManager().getTablist(event.getPlayer()).ifPresent(tablist -> tablist.getSlots().clear());
        Poseidon.getInstance().getTablistManager().removeTablist(event.getPlayer());
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        if (!event.getPlugin().equals(Poseidon.getInstance().getPlugin())) return;
        Poseidon.getInstance().getTablistTask().cancel();
        Poseidon.getInstance().getTablistManager().getTablists().values().forEach(tablist -> tablist.getSlots().clear());
        Poseidon.getInstance().getTablistManager().getTablists().clear();
        Poseidon.getInstance().getTablistKeyGenerator().clearKeys();
    }
}
