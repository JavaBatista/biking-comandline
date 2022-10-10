package com.javabatista.biking;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.repository.CyclingDayList;
import com.javabatista.biking.repository.CyclingDayRepository;
import com.javabatista.biking.service.MonthStats;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CyclingDayRepository repository = new CyclingDayRepository();
//	    Util.printFormattedList(repository.findByDate(LocalDate.of(2020, 11, 5)));
//        Util.printFormattedList(repository.findByYear(2020));

        List<CyclingDay> cyclingDays = repository.findByMonthOfYear(LocalDate.of(2020, 12, 5));
        Util.printFormattedList(cyclingDays);

        System.out.println(MonthStats.stats(cyclingDays));



    }
}
