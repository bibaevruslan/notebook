package com.github.notebook.client;

public class NotebookApplication {

    private final ApplicationContext context;

    public NotebookApplication(ApplicationContext context) {
        this.context = context;
    }

    private void initialize() {
        System.out.println("Добро пожаловать!");
        this.context.setWaiting(true);
    }

    private void doCommandWait() {
        System.out.print("Введите команду: ");
        this.context.resetCurrentLine();
    }

    public void start() {
        this.initialize();
        while(this.context.isWaiting()) {
            this.doCommandWait();
            this.context.getCommandPool().execute(this.context);
        }
    }

}
