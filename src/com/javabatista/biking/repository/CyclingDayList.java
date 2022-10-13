package com.javabatista.biking.repository;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.domain.WindCondition;

import java.time.*;
import java.time.temporal.TemporalField;
import java.util.*;

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

    private static WindCondition randomWindCondition() {
        Random RANDOM = new Random();
        int pick = new Random().nextInt(WindCondition.values().length);
        return WindCondition.values()[pick];
    }

    public static int random(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    private  static LocalTime cyclingTime(Double distance, Double avgSpeed) {
        Double time = distance / avgSpeed;
        double horas = Math.floor(time);
        double minutos = Math.floor((time - horas)*60);

        return LocalTime.of( (int) horas, (int) minutos, 0);
    }

    private  static LocalTime finishTime(LocalTime startTime, LocalTime cyclingTime) {

        return startTime.plusHours(cyclingTime.getHour()).plusMinutes(cyclingTime.getMinute());
    }



    public static List<CyclingDay> createCyclingDayList() {
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

//        System.out.println(actualDate);
//        System.out.println(calendar.getTime());
//        System.out.println(randomWindCondition());
//        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        while (!actualDate.equals(finalDate)) {

//            System.out.println(actualDate);
//            System.out.println(calendar.getTime());
//            System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

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

            //Chance aleatória de o dia ser incluido na lista
            int coin = random(0,1);
            if (coin == 1)
                daysList.add(cyclingDay);

            calendar.add(Calendar.DAY_OF_MONTH, 1);
            actualDate = LocalDate.ofInstant(calendar.toInstant(), ZoneId.systemDefault());

        }//end outer loop


        return daysList;
    }

    static  {
        cyclingDayList = createCyclingDayList();

                Arrays.asList(
                createCyclingDay(
                    LocalDate.of(2021, 9, 17),
                    LocalTime.of(8, 20, 30),
                    LocalTime.of(9, 37, 0),
                    LocalTime.of(1, 7, 0),
                    20.091, 39.739, 35.7, 18.1, WindCondition.MILD,
                    ""
                ),
                createCyclingDay(
                        LocalDate.of(2021, 9, 18),
                        LocalTime.of(8, 0, 7),
                        LocalTime.of(8, 50, 45),
                        LocalTime.of(0, 50, 26),
                        16.857, 56.596, 41.1, 20.0, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 9, 30),
                        LocalTime.of(7, 50, 25),
                        LocalTime.of(9, 11, 10),
                        LocalTime.of(1, 21, 19),
                        26.106, 91.488, 40.7, 19.3, WindCondition.WEAK,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 10, 1),
                        LocalTime.of(7, 30, 14),
                        LocalTime.of(8, 3, 10),
                        LocalTime.of(0, 32, 39),
                        11.750, 103.23, 34.4, 21.5, WindCondition.WEAK,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 10, 4),
                        LocalTime.of(8, 0, 25),
                        LocalTime.of(9, 18, 10),
                        LocalTime.of(1, 17, 10),
                        27.156, 130.39, 33.2, 21.2, WindCondition.WEAK,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 10, 21),
                        LocalTime.of(8, 10, 18),
                        LocalTime.of(9, 35, 10),
                        LocalTime.of(1, 24, 20),
                        27.015, 157.41, 44.5, 19.2, WindCondition.WEAK,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 10, 30),
                        LocalTime.of(7, 50, 25),
                        LocalTime.of(8, 56, 47),
                        LocalTime.of(1, 6, 50),
                        22.109, 179.52, 42.0, 19.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 11, 5),
                        LocalTime.of(7, 0, 5),
                        LocalTime.of(8, 18, 10),
                        LocalTime.of(1, 17, 5),
                        22.372, 201.89, 40.7, 17.4, WindCondition.MILD,
                        "Chuva na noite anterior. Lama na estrada"
                ),

                createCyclingDay(
                        LocalDate.of(2021, 11, 10),
                        LocalTime.of(7, 47, 5),
                        LocalTime.of(8, 49, 10),
                        LocalTime.of(1, 1, 40),
                        20.139, 222.03, 42.5, 19.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 5),
                        LocalTime.of(7, 50, 10),
                        LocalTime.of(9, 2, 41),
                        LocalTime.of(1, 11, 59),
                        22.261, 262.16, 31.3, 18.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 8),
                        LocalTime.of(8, 0, 12),
                        LocalTime.of(9, 10, 41),
                        LocalTime.of(1, 9, 36),
                        22.224, 284.38, 35.0, 19.1, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 12),
                        LocalTime.of(8, 0, 58),
                        LocalTime.of(9, 42, 41),
                        LocalTime.of(1, 20, 27),
                        24.978, 309.36, 37.8, 18.6, WindCondition.WEAK,
                        "Sai do percurso. Fui em uma loja"
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 18),
                        LocalTime.of(8, 10, 12),
                        LocalTime.of(9, 28, 0),
                        LocalTime.of(1, 17, 36),
                        24.246, 333.61, 34.1, 18.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 19),
                        LocalTime.of(7, 20, 59),
                        LocalTime.of(8, 28, 0),
                        LocalTime.of(1, 8, 9),
                        22.235, 355.83, 34.4, 19.6, WindCondition.HIGH,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 22),
                        LocalTime.of(7, 45, 18),
                        LocalTime.of(8, 49, 50),
                        LocalTime.of(1, 4, 37),
                        22.181, 378.01, 37.1, 20.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 24),
                        LocalTime.of(8, 10, 14),
                        LocalTime.of(9, 14, 50),
                        LocalTime.of(1, 3, 22),
                        22.267, 400.28, 36.4, 21.2, WindCondition.WEAK,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2021, 12, 26),
                        LocalTime.of(7, 55, 30),
                        LocalTime.of(9, 56, 50),
                        LocalTime.of(1, 1, 14),
                        22.233, 422.51, 33.2, 21.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 1, 7),
                        LocalTime.of(7, 33, 18),
                        LocalTime.of(8, 36, 47),
                        LocalTime.of(1, 3, 30),
                        22.317, 444.83, 40.2, 21.0, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 1, 8),
                        LocalTime.of(7, 58, 32),
                        LocalTime.of(9, 3, 47),
                        LocalTime.of(1, 4, 46),
                        22.385, 467.22, 36.4, 20.9, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 1, 19),
                        LocalTime.of(8, 0, 15),
                        LocalTime.of(9, 6, 47),
                        LocalTime.of(1, 6, 18),
                        22.319, 489.53, 36.7, 20.2, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 1, 21),
                        LocalTime.of(8, 10, 29),
                        LocalTime.of(9, 19, 47),
                        LocalTime.of(1, 8, 43),
                        23.100, 512.63, 42.0, 20.2, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 1, 27),
                        LocalTime.of(8, 20, 10),
                        LocalTime.of(9, 29, 55),
                        LocalTime.of(1, 8, 48),
                        22.230, 553.49, 37.8, 19.5, WindCondition.HIGH,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 1, 31),
                        LocalTime.of(8, 15, 58),
                        LocalTime.of(9, 22, 55),
                        LocalTime.of(1, 5, 49),
                        22.224, 575.71, 33.2, 20.3, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 2, 2),
                        LocalTime.of(7, 55, 19),
                        LocalTime.of(8, 58, 36),
                        LocalTime.of(1, 2, 37),
                        22.247, 597.96, 36.4, 21.3, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 2, 5),
                        LocalTime.of(7, 25, 17),
                        LocalTime.of(8, 31, 46),
                        LocalTime.of(1, 5, 12),
                        22.329, 620.29, 33.5, 20.6, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 2, 7),
                        LocalTime.of(7, 10, 13),
                        LocalTime.of(8, 32, 36),
                        LocalTime.of(1, 21, 59),
                        30.109, 650.40, 32.9, 22.1, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 2, 13),
                        LocalTime.of(7, 30, 19),
                        LocalTime.of(8, 57, 5),
                        LocalTime.of(1, 26, 46),
                        30.058, 680.46, 38.2, 20.7, WindCondition.MILD,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 2, 14),
                        LocalTime.of(7, 0, 19),
                        LocalTime.of(8, 23, 36),
                        LocalTime.of(1, 22, 35),
                        30.194, 710.65, 34.4, 22.0, WindCondition.WEAK,
                        ""
                ),

                createCyclingDay(
                        LocalDate.of(2022, 2, 17),
                        LocalTime.of(7, 55, 17),
                        LocalTime.of(8, 56, 36),
                        LocalTime.of(1, 0, 27),
                        21.406, 732.06, 37.1, 21.1, WindCondition.MILD,
                        ""
                )
        );
    }

}
