package com.github.notebook;

import com.github.notebook.client.ApplicationContext;
import com.github.notebook.client.NotebookApplication;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ApplicationContext();
        NotebookApplication application = new NotebookApplication(context);
        application.start();
    }

}
