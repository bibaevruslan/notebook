package com.github.notebook.command;

import java.util.List;

import com.github.notebook.storage.Note;
import com.github.notebook.client.ApplicationContext;

public class StatisticsCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        if (context.getCurrentLine().equals("#statistics")) {
            this.showStatistics(context);
        }
    }

    private void showStatistics(ApplicationContext context) {
        System.out.printf("Количество заметок: %d%n",
                context.getStorage().getSavedNotes().size());
        System.out.printf("Количество символов в содержании: %d%n",
                this.getNumberOfCharactersInNotes(context.getStorage().getSavedNotes()));
    }

    private int getNumberOfCharactersInNotes(List<Note> notes) {
        // FIXME: 10.06.2024 Fix the encoding for correct character counting. One cyrillic character is read as two
        int numberOfCharacters = 0;
        for (Note note : notes) {
            numberOfCharacters += note.content().length();
        }
        return numberOfCharacters;
    }

}
