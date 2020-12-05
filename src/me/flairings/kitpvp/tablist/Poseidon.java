package me.flairings.kitpvp.tablist;

import com.google.common.base.Preconditions;
import me.flairings.kitpvp.tablist.tablist.TablistKeyGenerator;
import me.flairings.kitpvp.tablist.tablist.TablistListener;
import me.flairings.kitpvp.tablist.tablist.TablistManager;
import me.flairings.kitpvp.tablist.tablist.TablistTask;
import org.bukkit.plugin.java.JavaPlugin;

public final class Poseidon {

    private static Poseidon instance;
    private final JavaPlugin plugin;
    private final TablistKeyGenerator tablistKeyGenerator;
    private final TablistManager tablistManager;
    private final TablistTask tablistTask;

    public Poseidon(JavaPlugin plugin, long period) {
        Preconditions.checkNotNull(plugin, "JavaPlugin cannot be null");
        instance = this;
        this.plugin = plugin;
        this.tablistKeyGenerator = new TablistKeyGenerator();
        this.tablistManager = new TablistManager();
        new TablistListener();
        this.tablistTask = new TablistTask(period);
    }

    public static Poseidon getInstance() {
        return instance;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public TablistKeyGenerator getTablistKeyGenerator() {
        return tablistKeyGenerator;
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }

    public TablistTask getTablistTask() {
        return tablistTask;
    }
}
