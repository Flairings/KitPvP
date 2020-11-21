package me.flairings.kitpvp.events;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.Bukkit.dispatchCommand;
import static org.bukkit.Bukkit.getConsoleSender;

public class KillRewardsEvent implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.isDead() && player.getKiller() instanceof Player) {
            Player killer = player.getKiller();
            killer.giveExpLevels(Main.getInstance().getConfig().getInt("kill-rewards.xp-amount"));
            for (String commands : Main.getInstance().getConfig().getStringList("kill-rewards.commands")) {
                dispatchCommand(getConsoleSender(), commands.replace("{PLAYER}", killer.getName()));
                if (Main.getInstance().getConfig().getBoolean("kill-rewards.sound-enabled")) {
                    player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 2F, 1F);
                }
                killer.sendMessage(CC.translate(Main.getInstance().getConfig().getString("kill-rewards.message"))
                        .replace("{PLAYER}", "" + player.getName())
                        .replace("{PREFIX}", "" + (CC.translate(Main.getInstance().getConfig().getString("Prefix")))));
            }
        }
    }
}