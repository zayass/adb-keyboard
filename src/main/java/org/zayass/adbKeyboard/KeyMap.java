package org.zayass.adbKeyboard;

import java.util.HashMap;
import java.util.Map;

public class KeyMap {

    private final Map<Integer, String> keyMap;

    public KeyMap() {
        keyMap = new HashMap<>();
        loadKeyMap();
    }

    private void loadKeyMap() {
        bind(127, "67");
    }

    private void bind(int keyCode, String keyName) {
        keyMap.put(keyCode, keyName);
    }

    public boolean hasKey(int keyCode) {
        return keyMap.containsKey(keyCode);
    }

    public String getKeyName(int keyCode) {
        return keyMap.get(keyCode);
    }
}
