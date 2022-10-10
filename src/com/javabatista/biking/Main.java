package com.javabatista.biking;

import com.javabatista.biking.repository.CyclingDayList;
import com.javabatista.biking.repository.CyclingDayRepository;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        CyclingDayRepository repository = new CyclingDayRepository();
//	    System.out.println(repository.findByDate(LocalDate.of(2020, 11, 5)));
        System.out.println(repository.findByYear(2020));

    }
}
