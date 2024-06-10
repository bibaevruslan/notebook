package com.github.notebook.storage;

import java.nio.charset.spi.CharsetProvider;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

public class Storage {

    private final Path pathToFile;

    public Storage() {
        this.pathToFile = Paths.get("src/main/resources/storage.txt");
        this.createFile();
    }

    public void saveNote(Note note) {
        this.appendToFile(note.toString() + System.lineSeparator());
    }

    public List<Note> getSavedNotes() {
        try (var lines = Files.lines(Paths.get(this.pathToFile.toUri()), StandardCharsets.UTF_8)) {
            return lines.map(this::fromFileLine).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void createFile() {
        if (!Files.exists(this.pathToFile)) {
            try {
                Files.createFile(this.pathToFile);
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    private void appendToFile(String content) {
        try {
            Files.writeString(
                    this.pathToFile,
                    content,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.APPEND
            );
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Note fromFileLine(String line) {
        String[] pair = line.split(" ", 2);
        String date = pair[0];
        String content = pair[1];
        return new Note(content, LocalDate.parse(date));
    }

}
