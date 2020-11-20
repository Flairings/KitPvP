package me.flairings.kitpvp.api;

import me.flairings.kitpvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;


public class InventoryHandler implements Listener {
    private List<InventoryProvider> inventories;

    public InventoryHandler init() {
        this.inventories = new ArrayList<InventoryProvider>();
        Bukkit.getPluginManager().registerEvents(this, Main.instance);
        return this;
    }

    public void registerInventory(InventoryProvider inventory) {
        this.inventories.add(inventory);
    }

    @EventHandler
    private void onEvent(InventoryClickEvent event) {
        try {
            Inventory inv = event.getClickedInventory();
            ItemStack item = event.getCurrentItem();
            for (InventoryProvider provider : this.inventories) {
                if (provider.getTitle().equals(inv.getTitle()) && inv.getType() == InventoryType.CHEST) {
                    provider.onClick(item, event.getRawSlot(), event);
                }
            }
        } catch (Exception ex) {
        }
    }
}
