package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ProfileCommand implements CommandExecutor {

    public ProfileCommand(Main plugin) {
        plugin.getCommand("profile").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // lmao been "in development" for like 2 weeks.
        commandSender.sendMessage(CC.translate("&cThis command is currently in development."));
        return false;
    }
}
