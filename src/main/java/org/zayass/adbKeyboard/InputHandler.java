package org.zayass.adbKeyboard;

import jline.console.ConsoleReader;

import java.io.IOException;

public class InputHandler {
    private final ConsoleReader consoleReader;

    public InputHandler() throws IOException {
        consoleReader = new ConsoleReader();
    }

    public void start() throws IOException {
        while (handleKeypress());
    }

    private boolean handleKeypress() throws IOException {
        int key = consoleReader.readCharacter();
        System.out.println(key);
        System.out.println(Character.toChars(key));
        return true;
    }
}
