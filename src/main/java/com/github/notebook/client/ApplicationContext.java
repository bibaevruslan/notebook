package com.github.notebook.client;

import com.github.notebook.storage.Storage;
import com.github.notebook.command.CommandPool;

import java.util.Scanner;

public final class ApplicationContext {

    private final Storage storage;
    private final Scanner scanner;
    private final CommandPool commandPool;
    private String currentLine;
    private boolean isWaiting;

    public ApplicationContext() {
        this.scanner = new Scanner(System.in);
        this.storage = new Storage();
        this.commandPool = new CommandPool();
        this.currentLine = "";
        this.isWaiting = false;
    }

    public void resetCurrentLine() {
        this.setCurrentLine(this.getScanner().nextLine());
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public Storage getStorage() {
        return this.storage;
    }

    public CommandPool getCommandPool() {
        return this.commandPool;
    }

    public String getCurrentLine() {
        return currentLine;
    }

    public void setCurrentLine(String currentLine) {
        this.currentLine = currentLine;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

}
