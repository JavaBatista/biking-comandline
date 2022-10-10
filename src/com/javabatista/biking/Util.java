package com.javabatista.biking;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String durationToString(Duration duration) {
        return "%02d:%02d:%02d".formatted( duration.toHoursPart(),
                duration.toMinutesPart(),
                duration.toSecondsPart() );

    }

    public static String localDateFormatter(LocalDate localDate)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return localDate.format(formatter);
    }

    public static String localTimeFormatter(LocalTime localTime)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localTime.format(formatter);
    }
}
