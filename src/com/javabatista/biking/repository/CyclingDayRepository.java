package com.javabatista.biking.repository;

import com.javabatista.biking.domain.CyclingDay;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CyclingDayRepository {

    private List<CyclingDay> cyclingDayList = CyclingDayList.cyclingDayList;

    public List<CyclingDay> findByDate(LocalDate date) {
        return cyclingDayList.stream().filter( cyclingDay -> cyclingDay.getDate().equals(date)).collect(Collectors.toList());
    }

    public List<CyclingDay> findByYear(Integer year) {
        return cyclingDayList.stream().filter(
                    cyclingDay -> cyclingDay.getDate().getYear() == year
                ).collect(Collectors.toList());
    }

    public List<CyclingDay> findByMonthOfYear(LocalDate date) {
         List<CyclingDay> byYear = cyclingDayList.stream().filter(
                cyclingDay -> cyclingDay.getDate().getYear() == date.getYear()
        ).collect(Collectors.toList());

         return byYear.stream().filter(
                 cyclingDay -> cyclingDay.getDate().getMonth() == date.getMonth()
         ).collect(Collectors.toList());
    }

}
