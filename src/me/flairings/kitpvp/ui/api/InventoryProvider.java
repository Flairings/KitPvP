package me.flairings.kitpvp.ui.api;

import me.flairings.kitpvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class InventoryProvider {
    private String title;
    private int size;
    private Inventory inventory;

    public InventoryProvider(String title, int size) {
        this.title = title;
        this.size = size;
        Main.getInventoryHandler().registerInventory(this);
    }

    public abstract void init(Player p0);

    public abstract void onClick(ItemStack p0, int p1, InventoryClickEvent p2);

    public void open(Player player) {
        this.inventory = Bukkit.createInventory(null, this.size, this.title);
        this.init(player);
        player.openInventory(this.inventory);
    }

    public void fill(ItemStack item) {
        for (int i = 0; i <= this.size - 1; ++i) {
            this.inventory.setItem(i, item);
        }
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
