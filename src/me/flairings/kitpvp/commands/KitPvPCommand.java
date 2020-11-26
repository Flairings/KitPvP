package me.flairings.kitpvp.commands;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class KitPvPCommand implements CommandExecutor {

    public KitPvPCommand(Main plugin) {
        plugin.getCommand("kitpvp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (args.length < 1) {
            if (commandSender.hasPermission("kitpvp.command.helpcommand")) {
                commandSender.sendMessage(CC.translate("\n" +
                        "&7&m------------------------------------------- \n" +
                        "&6&lKitPvP &7┃ &fMain Page \n" +
                        "&7&m------------------------------------------- \n" +
                        "&6/kitpvp stats &7┃ &fAll help reguarding stats commands \n" +
                        "&6/kitpvp build &7┃ &fAll help reguarding build commands \n" +
                        "&6/kitpvp reload &7┃ &fAll help reguarding reload commands \n" +
                        "&6/kitpvp howtoplay &7┃ &fAll help reguarding howtoplay commands \n" +
                        "&6/kitpvp killrewards &7┃ &fAll help reguarding killreward commands \n" +
                        "&7&m------------------------------------------- \n"));
            } else {
                commandSender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
            }
            return false;
        } else {
            if (args[0].equalsIgnoreCase("howtoplay")) {
                if (commandSender.hasPermission("kitpvp.helpcommand.howtoplay")) {
                    commandSender.sendMessage(CC.translate("\n" +
                            "&7&m------------------------------------------- \n" +
                            "&6&lKitPvP &7┃ &fHow To Play Page \n" +
                            "&7&m------------------------------------------- \n" +
                            "&6/howtoplay &7┃ &fDisplays servers help menu \n" +
                            "&6/howtoplay <player> &7┃ &fDisplays for another player \n" +
                            "&7&m------------------------------------------- \n"));
                } else {
                    commandSender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
                }
            }
            if (args[0].equalsIgnoreCase("stats")) {
                if (commandSender.hasPermission("kitpvp.helpcommand.stats")) {
                    commandSender.sendMessage(CC.translate("\n" +
                            "&7&m------------------------------------------- \n" +
                            "&6&lKitPvP &7┃ &fStats Page \n" +
                            "&7&m------------------------------------------- \n" +
                            "&6/stats &7┃ &fView your own statistics \n" +
                            "&6/stats <player> &7┃ &fView another players statistics \n" +
                            "&7&m------------------------------------------- \n"));
                } else {
                    commandSender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
                }
            }
            if (args[0].equalsIgnoreCase("build")) {
                if (commandSender.hasPermission("kitpvp.helpcommand.build")) {
                    commandSender.sendMessage(CC.translate("\n" +
                            "&7&m------------------------------------------- \n" +
                            "&6&lKitPvP &7┃ &fBuild Page \n" +
                            "&7&m------------------------------------------- \n" +
                            "&6/build &7┃ &fToggles breaking and placing blocks \n" +
                            "&7&m------------------------------------------- \n"));
                } else {
                    commandSender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
                }
            }
            if (args[0].equalsIgnoreCase("reload")) {
                if (commandSender.hasPermission("kitpvp.helpcommand.reload")) {
                    commandSender.sendMessage(CC.translate("\n" +
                            "&7&m------------------------------------------- \n" +
                            "&6&lKitPvP &7┃ &fReload Page \n" +
                            "&7&m------------------------------------------- \n" +
                            "&6/kitpvp-reload &7┃ &fReloads the KitPvP config files. \n" +
                            "&7&m------------------------------------------- \n"));
                } else {
                    commandSender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
                }
            }
            if (args[0].equalsIgnoreCase("killrewards")) {
                if (commandSender.hasPermission("kitpvp.helpcommand.killrewards")) {
                    commandSender.sendMessage(CC.translate("\n" +
                            "&7&m------------------------------------------- \n" +
                            "&6&lKitPvP &7┃ &fKill rewards Page \n" +
                            "&7&m------------------------------------------- \n" +
                            "&6/killrewards &7┃ &fView current Kill reward settings. \n" +
                            "&7&m------------------------------------------- \n"));
                } else {
                    commandSender.sendMessage(CC.translate(Main.getInstance().getConfig().getString("No-Permissions-Message")));
                }
            }
        }
        return false;
        }
    }
