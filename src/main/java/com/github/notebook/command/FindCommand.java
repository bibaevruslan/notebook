package com.github.notebook.command;

import java.util.List;
import java.time.LocalDate;

import com.github.notebook.date.DateConstants;
import com.github.notebook.storage.Note;
import com.github.notebook.client.ApplicationContext;

public class FindCommand implements Command {

    @Override
    public void execute(ApplicationContext context) {
        if (context.getCurrentLine().equals("#find")) {
            this.showFoundNotes(context);
        }
    }

    private void showFoundNotes(ApplicationContext context) {
        System.out.print("Введите дату заметки: ");
        String date = context.getScanner().nextLine();
        if (DateConstants.DATE_PATTERN.matcher(date).matches()) {
            List<Note> searchedNotes = context.getStorage().getSavedNotes()
                    .stream()
                    .filter(note -> note.date().isEqual(LocalDate.parse(date))).toList();
            if (searchedNotes.isEmpty()) {
                System.out.printf("Заметок записанных %s не найдено%n", date);
            } else {
                searchedNotes.forEach(System.out::println);
            }
        } else {
            System.out.printf("Введите дату в формате %s%n", LocalDate.now().format(DateConstants.DATE_FORMAT));
        }

    }

}
