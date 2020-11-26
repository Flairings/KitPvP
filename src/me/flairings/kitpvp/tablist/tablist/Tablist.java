package me.flairings.kitpvp.tablist.tablist;

import com.google.common.base.Preconditions;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Tablist {

    private static final int MAX_TABLIST_SLOTS = 80;

    private final Player player;
    private final List<TablistSlot> slots;

    public Tablist(Player player) {
        Preconditions.checkNotNull(player, "Player cannot be null");
        this.player = player;
        this.slots = Collections.synchronizedList(new ArrayList<>(MAX_TABLIST_SLOTS));
        IntStream.range(0, MAX_TABLIST_SLOTS).forEach(index -> this.slots.add(new TablistSlot(index)));
    }

    @Deprecated
    public TablistSlot getSlot(int index) {
        Preconditions.checkArgument(index > -1 && index < 80, "Index out of bounds, the range is 0-79");
        return this.slots.get(index);
    }

    public TablistSlot getSlot(int column, int row) {
        Preconditions.checkArgument(column > -1 && column < 4, "Column out of bounds, the range is 0-3");
        Preconditions.checkArgument(row > -1 && row < 20, "Row out of bounds, the range is 0-19");
        return this.slots.get(column * 20 + row);
    }

    public Player getPlayer() {
        return player;
    }

    protected List<TablistSlot> getSlots() {
        return slots;
    }
}
