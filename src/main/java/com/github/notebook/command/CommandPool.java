package com.github.notebook.command;

import java.util.Set;
import com.github.notebook.client.ApplicationContext;

public class CommandPool {

    private final Set<Command> grantedCommands;

    public void execute(ApplicationContext context) {
        this.grantedCommands.forEach(command -> command.execute(context));
    }

    {
        grantedCommands = Set.of(
            new WarningCommand(),
            new WriteCommand(),
            new ReadCommand(),
            new FindCommand(),
            new StatisticsCommand(),
            new ExitCommand()
        );
    }

}
