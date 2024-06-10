package com.github.notebook.command;

import java.util.List;

import com.github.notebook.storage.Note;
import com.github.notebook.client.ApplicationContext;


public class ReadCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        if (context.getCurrentLine().equals("#read")) {
            this.showSavedNotes(context);
        }
    }

    private void showSavedNotes(ApplicationContext context) {
        List<Note> savedNotes = context.getStorage().getSavedNotes();
        if (savedNotes.isEmpty()) {
            System.out.println("Список заметок пуст");
        } else {
            savedNotes.forEach(System.out::println);
        }
    }

}
