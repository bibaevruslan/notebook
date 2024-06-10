package com.github.notebook.storage;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import com.github.notebook.date.DateConstants;

public record Note(String content, LocalDate date) implements Serializable {

    @Serial
    private static final long serialVersionUID = 42L;

    @Override
    public String toString() {
        return String.join(" ", this.date.format(DateConstants.DATE_FORMAT), this.content);
    }

}
