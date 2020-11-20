package me.flairings.kitpvp.ui;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.api.InventoryProvider;
import me.flairings.kitpvp.api.ItemBuilder;
import me.flairings.kitpvp.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HowToPlayUI extends InventoryProvider {
    public HowToPlayUI() {
        super(CC.translate("&dUnoPvP &8┃ &fHelp"), 27);
    }

    @Override
    public void init(Player player) {
        Inventory inv = this.getInventory();
        String kitPvPTitle = CC.translate(Main.settings.getConfiguration().getString("items.kitpvp.title"));
        List<String> lore = Main.settings.getConfiguration().getStringList("items.kitpvp.lore");
        List<String> kitPvPCommandsLore = new ArrayList<String>();
        for (String kitpvplore : lore) {
            kitPvPCommandsLore.add(CC.translate(kitpvplore));
        }
        ItemStack kitpvpCommands = new ItemBuilder(Material.BOOK).setLore(kitPvPCommandsLore).setName(kitPvPTitle).toItemStack();
        String howPlayTitle = CC.translate(Main.settings.getConfiguration().getString("items.howplay.title"));
        List<String> lore2 = Main.settings.getConfiguration().getStringList("items.howplay.lore");
        List<String> howPlayLore = new ArrayList<String>();
        for (String kitpvplore2 : lore2) {
            howPlayLore.add(CC.translate(kitpvplore2));
        }
        ItemStack howPlay = new ItemBuilder(Material.BOOK).setLore(howPlayLore).setName(howPlayTitle).toItemStack();
        String econTitle = CC.translate(Main.settings.getConfiguration().getString("items.economy.title"));
        List<String> lore3 = Main.settings.getConfiguration().getStringList("items.economy.lore");
        List<String> econLore = new ArrayList<String>();
        for (String kitpvplore3 : lore3) {
            econLore.add(CC.translate(kitpvplore3));
        }
        ItemStack econ = new ItemBuilder(Material.BOOK).setLore(econLore).setName(econTitle).toItemStack();
        inv.setItem(11, kitpvpCommands);
        inv.setItem(13, howPlay);
        inv.setItem(15, econ);
    }

    @Override
    public void onClick(ItemStack item, int slot, InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
    }
}
