package me.flairings.kitpvp.tablist.tablist;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// Sorting Method Taken From...
// https://github.com/kacperduras/ProtocolTab/blob/master/src/main/java/pl/kacperduras/protocoltab/manager/ProtocolTab.java
public final class TablistKeyGenerator {

    private final static char[] ALPHABET = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T'
    };

    private final List<String> keys;

    public TablistKeyGenerator() {
        this.keys = new ArrayList<>();
        IntStream.range(0, 80).forEach(index -> {
            if (index < 20) this.keys.add("A-" + ALPHABET[index]);
            else if (index < 40) this.keys.add("B-" + ALPHABET[index - 20]);
            else if (index < 60) this.keys.add("C-" + ALPHABET[index - 40]);
            else if (index < 80) this.keys.add("D-" + ALPHABET[index - 60]);
        });
    }

    public String getNextKey(int index) {
        Preconditions.checkArgument(index > -1 && index < 80, "Index out of bounds, the range is 0-79");
        return this.keys.get(index);
    }

    public void clearKeys() {
        this.keys.clear();
    }

}
