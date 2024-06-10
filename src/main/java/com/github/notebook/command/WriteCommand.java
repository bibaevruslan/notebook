package com.github.notebook.command;

import java.time.LocalDate;

import com.github.notebook.storage.Note;
import com.github.notebook.client.ApplicationContext;


public class WriteCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        if (context.getCurrentLine().equals("#write")) {
            this.saveNote(context);
        }
    }

    private void saveNote(ApplicationContext context) {
        System.out.print("Введите ваши планы на сегодня: ");
        String content = context.getScanner().nextLine();
        context.getStorage().saveNote(new Note(content, LocalDate.now()));
        System.out.println("Запись успешно добавлена");
    }

}
