package me.flairings.kitpvp.tablist.tablist;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TablistManager {

    private final Map<UUID, Tablist> tablists;

    public TablistManager() {
        this.tablists = new ConcurrentHashMap<>();
    }

    public void addTablist(Player player) {
        this.tablists.putIfAbsent(player.getUniqueId(), new Tablist(player));
    }

    public void removeTablist(Player player) {
        this.tablists.remove(player.getUniqueId());
    }

    public Optional<Tablist> getTablist(Player player) {
        return Optional.ofNullable(this.tablists.get(player.getUniqueId()));
    }

    public Map<UUID, Tablist> getTablists() {
        return tablists;
    }
}
