package me.flairings.kitpvp.tablist.tablist;

import com.comphenix.protocol.wrappers.WrappedGameProfile;
import com.comphenix.protocol.wrappers.WrappedSignedProperty;
import com.google.common.base.Preconditions;
import me.flairings.kitpvp.tablist.Poseidon;

import java.util.UUID;

public class TablistSlot {

    private static final WrappedSignedProperty DEFAULT_SKIN = new WrappedSignedProperty("textures",
            "ewogICJ0aW1lc3RhbXAiIDogMTYwMDM2NDk1ODcyOCwKICAicHJvZmlsZUlkIiA6ICJiNzQ3OWJhZTI5YzQ0YjIzYmE1NjI4MzM3OGYwZTNjNiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTeWxlZXgiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTViZTY4MmJkMTczODU0OGIyZmZiNWY1NGYyNmZjOTA5YmEyMTFlYmJhMjFlNTI0ZmMwYWUzYmQzMjU2ZWY1YyIKICAgIH0KICB9Cn0=",
            "uY3YzVO2qF9XwGGGaVrv7IEsSOm4IIoxlc0i40ujt0fAmgcOrqnT3S/K48PBvHkCC+1RS/rr+m2Zh3dpdfFhuQxiF4kpXyLRN7pSjzEjvr4px6kxx2jZqUTisTXLBsqCXxT22o2cVWlKflVf1FNo/ZNCHnjTXc9pA1diR4VFo/PJbpr0qG6dN61D6rqEDz8vzQeMyTUkby6ALceYu+ZglfgurAFpyPusbFrBvChOBva256HkDXXLnMsDEqyFet9mAuAsWjLgIANxkAl0jVhiTTocszlSXYZVCwHyRRMtCKVNMtZ4Or5rm1BnBqRDrR5G6RNaRvIYKXf1NzdN0A4Wtv4B2lIhAJicTMClLdtFS++4CagNZBIbfUzTJUydEy/xUQZlyY415KegwGcDpGULtg9FOouOwSx+cR4H9HCCSfbhK+NV7jtY6LGmgnh07tOH2dfYMhiJT6/vSHSufkhtATqMLBWBvSJA5QgXpZfAwPUuom69pa8lbeBTbvsIdc5KogivaQIaBkw3cV6JKd9zg5j34+VpcoRJR1IfKvLzY6JCsXwpB4lYVQrPpgUTfenQjeZMaF89GcEqC/OAxjwrFbVuG2Jyn9znFvkSezi6+nwXqI61Lm9svS6+Go249rqX2x2/iS9aL1yntvJxzzXfqgQzxFuFuw1UMpCjyEzTt2w=");

    private String text;
    private int latency;
    private final WrappedGameProfile profile;
    private boolean shouldUpdate;

    protected TablistSlot(int index) {
        this.text = " ";
        this.latency = 149;
        this.profile = new WrappedGameProfile(UUID.randomUUID(), "!" + Poseidon.getInstance().getTablistKeyGenerator().getNextKey(index));
        this.profile.getProperties().put("textures", DEFAULT_SKIN);
        this.shouldUpdate = true;
    }

    protected String getText() {
        return text;
    }

    protected int getLatency() {
        return latency;
    }

    protected WrappedGameProfile getProfile() {
        return profile;
    }

    protected boolean isShouldUpdate() {
        return shouldUpdate;
    }

    public void setText(String text) {
        Preconditions.checkNotNull(text , "Text cannot be null");
        if (this.text.equals(text)) return;
        this.text = text;
        this.shouldUpdate = true;
    }

    public void setLatency(Latency latency) {
        Preconditions.checkNotNull(latency, "Latency cannot be null");
        this.setLatency(latency.getValue());
    }

    public void setLatency(int latency) {
        if (this.latency == latency) return;
        this.latency = latency;
        this.shouldUpdate = true;
    }

    protected void setShouldUpdate(boolean shouldUpdate) {
        this.shouldUpdate = shouldUpdate;
    }
}
