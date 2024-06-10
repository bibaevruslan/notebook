package com.github.notebook.date;

import java.util.regex.Pattern;
import java.time.format.DateTimeFormatter;

public final class DateConstants {

    public static final Pattern DATE_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;

}
