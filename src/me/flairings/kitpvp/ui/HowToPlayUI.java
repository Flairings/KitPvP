package me.flairings.kitpvp.ui;

import me.flairings.kitpvp.Main;
import me.flairings.kitpvp.ui.api.InventoryProvider;
import me.flairings.kitpvp.ui.api.ItemBuilder;
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
        super(CC.translate(Main.getInstance().getConfig().getString("helpui.title")), Main.getInstance().getConfig().getInt("helpui.size"));
    }

    @Override
    public void init(Player player) {
        Inventory inv = this.getInventory();
        String kitPvPTitle = CC.translate(Main.getInstance().getConfig().getString("helpui.kitpvp.title"));
        List<String> lore = Main.getInstance().getConfig().getStringList("helpui.kitpvp.lore");
        List<String> kitPvPCommandsLore = new ArrayList<String>();
        for (String kitpvplore : lore) {
            kitPvPCommandsLore.add(CC.translate(kitpvplore));
        }
        ItemStack kitpvpCommands = new ItemBuilder(Material.getMaterial(Main.getInstance().getConfig().getString("helpui.kitpvp.item"))).setLore(kitPvPCommandsLore).setName(kitPvPTitle).toItemStack();
        String howPlayTitle = CC.translate(Main.getInstance().getConfig().getString("helpui.howplay.title"));
        List<String> lore2 = Main.getInstance().getConfig().getStringList("helpui.howplay.lore");
        List<String> howPlayLore = new ArrayList<String>();
        for (String kitpvplore2 : lore2) {
            howPlayLore.add(CC.translate(kitpvplore2));
        }
        ItemStack howPlay = new ItemBuilder(Material.getMaterial(Main.getInstance().getConfig().getString("helpui.howplay.item"))).setLore(howPlayLore).setName(howPlayTitle).toItemStack();
        String econTitle = CC.translate(Main.getInstance().getConfig().getString("helpui.economy.title"));
        List<String> lore3 = Main.getInstance().getConfig().getStringList("helpui.economy.lore");
        List<String> econLore = new ArrayList<String>();
        for (String kitpvplore3 : lore3) {
            econLore.add(CC.translate(kitpvplore3));
        }
        ItemStack econ = new ItemBuilder(Material.getMaterial(Main.getInstance().getConfig().getString("helpui.economy.item"))).setLore(econLore).setName(econTitle).toItemStack();
        inv.setItem((Main.getInstance().getConfig().getInt("helpui.kitpvp.itemposition")), kitpvpCommands);
        inv.setItem((Main.getInstance().getConfig().getInt("helpui.howplay.itemposition")), howPlay);
        inv.setItem((Main.getInstance().getConfig().getInt("helpui.economy.itemposition")), econ);
    }

    @Override
    public void onClick(ItemStack item, int slot, InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
    }
}
