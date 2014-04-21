package org.zayass.adbKeyboard;

import java.io.IOException;

public class KeyPressDispatcher {
    private final KeyMap keyMap;

    public KeyPressDispatcher() {
        keyMap = new KeyMap();
    }

    public void dispatchKeyCode(int keyCode) throws IOException {
        if (keyMap.hasKey(keyCode)) {
            dispatchSpecialKey(keyCode);
        } else if (isCharKey(keyCode)) {
            dispatchChar(keyCode);
        }
    }

    private void dispatchSpecialKey(int keyCode) throws IOException {
        String keyName = keyMap.getKeyName(keyCode);
        Runtime.getRuntime().exec("adb shell input keyevent " + keyName);
    }

    private void dispatchChar(int keyCode) throws IOException {
        String text = new String(Character.toChars(keyCode));
        Runtime.getRuntime().exec("adb shell input text " + text.replace(" ", "%s"));
    }

    private boolean isCharKey(int keyCode) {
        return Character.charCount(keyCode) > 0;
    }
}
