package com.github.notebook.command;

import com.github.notebook.client.ApplicationContext;

public class ExitCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        if (context.getCurrentLine().equals("#exit")) {
            this.exit(context);
        }
    }

    private void exit(ApplicationContext context) {
        context.setWaiting(false);
        context.getScanner().close();
    }

}
