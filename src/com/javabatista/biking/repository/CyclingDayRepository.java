package com.javabatista.biking.repository;

import com.javabatista.biking.domain.CyclingDay;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CyclingDayRepository {

    public CyclingDayRepository() {
        this.cyclingDayList = new CyclingDayList();
        this.cyclingDayS = this.cyclingDayList.getCyclingDayList();
    }

    private CyclingDayList cyclingDayList;
    private List<CyclingDay> cyclingDayS;

    public List<CyclingDay> findByDate(LocalDate date) {
        return cyclingDayS.stream().filter( cyclingDay -> cyclingDay.getDate().equals(date)).collect(Collectors.toList());
    }

    public List<CyclingDay> findByYear(Integer year) {
        return cyclingDayS.stream().filter(
                    cyclingDay -> cyclingDay.getDate().getYear() == year
                ).collect(Collectors.toList());
    }

    public List<CyclingDay> findByMonthOfYear(LocalDate date) {
         List<CyclingDay> byYear = cyclingDayS.stream().filter(
                cyclingDay -> cyclingDay.getDate().getYear() == date.getYear()
        ).collect(Collectors.toList());

         return byYear.stream().filter(
                 cyclingDay -> cyclingDay.getDate().getMonth() == date.getMonth()
         ).collect(Collectors.toList());
    }

    public Set<Integer> findYears() {
        Set<Integer> years = new HashSet<>();
        for (CyclingDay cyclingDay: cyclingDayS) {
            years.add(cyclingDay.getDate().getYear());
        }

        return  years;
    }

}
