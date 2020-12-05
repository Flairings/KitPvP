package me.flairings.kitpvp.tablist.tablist;

/**
 * Values taken from https://wiki.vg/Protocol, under the Player Info section.
 */
public enum Latency {

    FIVE_BARS(40),
    FOUR_BARS(80),
    THREE_BARS(120),
    TWO_BARS(230),
    ONE_BAR(300),
    NO_BAR(-1);

    private final int value;

    Latency(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
