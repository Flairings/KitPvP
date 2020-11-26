package me.flairings.kitpvp.tablist.tablist;

/**
 * Values taken from https://wiki.vg/Protocol, under the Player Info section.
 */
public enum Latency {

    FIVE_BARS(149),
    FOUR_BARS(299),
    THREE_BARS(599),
    TWO_BARS(999),
    ONE_BAR(1001),
    NO_BAR(-1);

    private final int value;

    Latency(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
