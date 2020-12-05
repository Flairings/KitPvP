package me.flairings.kitpvp.tablist;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PoseidonTablistTask extends BukkitRunnable {



    public PoseidonTablistTask() {
        runTaskTimerAsynchronously(Poseidon.getInstance().getPlugin(), 20L, 20L);
    }

    @Override
    public void run() {
        Main.getInstance().getPoseidon().getTablistManager().getTablists().values().forEach(tablist -> {
                for (int column = 0; column < 4; column++) {
                for (int row = 0; row < 20; row++)
                    // COLUMN 1
                    tablist.getSlot(0, 0).setText(CC.translate("&d&lUNOPVP"));
                    tablist.getSlot(0, 3).setText(CC.translate("&dStore"));
                    tablist.getSlot(0, 4).setText(CC.translate("&fstore.unopvp.com"));

                    // COLUMN 2
                    tablist.getSlot(1, 0).setText(CC.translate("&d&lSEASON ONE"));
                    tablist.getSlot(1, 1).setText(CC.translate("     &7(" + Bukkit.getServer().getOnlinePlayers().size() + "/" + Bukkit.getServer().getMaxPlayers() +")"));
                    tablist.getSlot(1, 3).setText(CC.translate("&dYour rank"));
                    tablist.getSlot(1, 4).setText(CC.translate("&a"));

                    // COLUMN 3
                    tablist.getSlot(2, 0).setText(CC.translate("&d&lUNOPVP"));
                    tablist.getSlot(2, 3).setText(CC.translate("&dDiscord"));
                    tablist.getSlot(2, 4).setText(CC.translate("&fdiscord.gg/unopvp"));

                    // COLUMN 4
                    tablist.getSlot(3, 0).setText(CC.translate("&d&lUNOPVP"));
                    tablist.getSlot(3, 3).setText(CC.translate("&4&lWARNING"));
                    tablist.getSlot(3, 4).setText(CC.translate("&fConnect with"));
                    tablist.getSlot(3, 5).setText(CC.translate("&f1.8 for the"));
                    tablist.getSlot(3, 6).setText(CC.translate("&foptimal playing"));
                    tablist.getSlot(3, 7).setText(CC.translate("&fperformance."));
            }
        });
    }
}