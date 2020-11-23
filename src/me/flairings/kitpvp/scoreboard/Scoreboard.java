package me.flairings.kitpvp.scoreboard;

import me.clip.placeholderapi.PlaceholderAPI;
import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.scoreboard.api.AssembleAdapter;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return ChatColor.GOLD.toString() + "&d&lUnoPvP &7┃ &fKitPvP";
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> toReturn = new ArrayList<>();
        for(String str : Main.getInstance().getConfig().getStringList("Scoreboard.Default")){
            str = CC.translate(str);
            str = PlaceholderAPI.setPlaceholders(player, str);
            toReturn.add(str);
        }
        return toReturn;
    }

}