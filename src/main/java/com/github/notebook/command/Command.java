package com.github.notebook.command;

import com.github.notebook.client.ApplicationContext;

public interface Command {

    String PREFIX = "#";

    void execute(ApplicationContext context);

}
