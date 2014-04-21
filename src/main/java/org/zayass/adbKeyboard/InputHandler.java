package org.zayass.adbKeyboard;

import jline.console.ConsoleReader;

import java.io.IOException;

public class InputHandler {
    private final ConsoleReader consoleReader;
    private final KeyPressDispatcher keypressDispatcher;

    public InputHandler() throws IOException {
        keypressDispatcher = new KeyPressDispatcher();
        consoleReader = new ConsoleReader();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    public void start() throws IOException {
        while (handleKeypress());
    }

    private boolean handleKeypress() throws IOException {
        int keyCode = consoleReader.readCharacter();

        keypressDispatcher.dispatchKeyCode(keyCode);

        System.out.println(keyCode);
        System.out.println(Character.toChars(keyCode));
        return true;
    }
}
