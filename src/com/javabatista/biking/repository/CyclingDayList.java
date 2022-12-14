package com.javabatista.biking.repository;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.domain.WindCondition;

import java.time.*;
import java.time.temporal.TemporalField;
import java.util.*;

public class CyclingDayList {

    private List<CyclingDay> cyclingDayList;

    public List<CyclingDay> getCyclingDayList() {
        return createCyclingDayList();
    }

    private Instant createInstant(LocalTime localTime, LocalDate localDate) {
        return LocalDateTime.of(localDate, localTime)
                .toInstant(ZoneId.systemDefault().getRules()
                        .getOffset(LocalDateTime.of(localDate, localTime)));
    }

    private  CyclingDay createCyclingDay( LocalDate date,
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

    private WindCondition randomWindCondition() {
        Random RANDOM = new Random();
        int pick = new Random().nextInt(WindCondition.values().length);
        return WindCondition.values()[pick];
    }

    private int random(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    private   LocalTime cyclingTime(Double distance, Double avgSpeed) {
        Double time = distance / avgSpeed;
        double horas = Math.floor(time);
        double minutos = Math.floor((time - horas)*60);

        return LocalTime.of( (int) horas, (int) minutos, 0);
    }

    private   LocalTime finishTime(LocalTime startTime, LocalTime cyclingTime) {

        return startTime.plusHours(cyclingTime.getHour()).plusMinutes(cyclingTime.getMinute());
    }



    private   List<CyclingDay> createCyclingDayList() {
        Random RANDOM = new Random();

        List<CyclingDay> daysList = new ArrayList<>(Collections.emptyList());
        // creating calendar object
        Calendar calendar = Calendar.getInstance();
        LocalDate finalDate = LocalDate.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        calendar.add(Calendar.YEAR, -1);
        LocalDate actualDate = LocalDate.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        LocalTime startTime = LocalTime.of(5, 30, 0);
        Double odometer = 0.0;
        String comments = "";

        while (!actualDate.equals(finalDate)) {

            Double distance = ((double) random(20, 30));
            Double avgSpeed = (double) random(18, 22);
            Double maxSpeed = (double) random(30, 45);
            odometer = odometer + distance;
            LocalTime cyclingTime = cyclingTime(distance, avgSpeed);
            LocalTime finishTime = finishTime(startTime, cyclingTime);
            WindCondition windCondition = randomWindCondition();

            CyclingDay cyclingDay = new CyclingDay(
                    actualDate,
                    createInstant(startTime, actualDate),
                    createInstant(finishTime, actualDate),
                    cyclingTime,
                    distance, odometer, maxSpeed, avgSpeed, windCondition,
                    comments
            );

            //Chance aleat??ria de o dia ser incluido na lista
            int coin = random(0,1);
            if (coin == 1)
                daysList.add(cyclingDay);

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            actualDate = LocalDate.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        }//end outer loop


        return daysList;
    }

}
