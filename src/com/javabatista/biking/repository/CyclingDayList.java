package com.javabatista.biking.repository;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.domain.WindCondition;

import java.time.*;
import java.util.List;

public class CyclingDayList {

    public static final List<CyclingDay> cyclingDayList;

    private static Instant createInstant(LocalTime localTime, LocalDate localDate) {
        return LocalDateTime.of(localDate, localTime)
                .toInstant(ZoneId.systemDefault().getRules()
                        .getOffset(LocalDateTime.of(localDate, localTime)));
    }

    private  static CyclingDay createCyclingDay( LocalDate date,
                                                 LocalTime startTime,
                                                 LocalTime finishTime,
                                                 LocalTime cyclingTime,
                                                 Double distance,
                                                 Double odometer,
                                                 Double maxSpeed,
                                                 Double avgSpeed,
                                                 WindCondition windCondition,
                                                 String comments) {
        return  new CyclingDay(
                        date,
                        createInstant(startTime, date),
                        createInstant(finishTime, date),
                        cyclingTime,
                        distance, odometer, maxSpeed, avgSpeed, windCondition,
                        comments
                    );
    }

    static  {
        cyclingDayList = List.of(
                createCyclingDay(
                    LocalDate.of(2020, 9, 17),
                    LocalTime.of(8, 20, 30),
                    LocalTime.of(9, 37, 0),
                    LocalTime.of(1, 7, 0),
                    20.091, 39.739, 35.7, 18.1, WindCondition.MILD,
                    ""
                )
        );
    }

}
