package com.github.notebook.command;

import com.github.notebook.client.ApplicationContext;

public class WarningCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        if (!context.getCurrentLine().startsWith(Command.PREFIX)) {
            System.out.println("Команда должна начинаться с символа #");
        }
    }

}
