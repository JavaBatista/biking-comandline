package com.javabatista.biking;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.repository.CyclingDayList;
import com.javabatista.biking.repository.CyclingDayRepository;
import com.javabatista.biking.service.MonthStats;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.exit;

public class Main {

    private static CyclingDayRepository repository = new CyclingDayRepository();

    public static void main(String[] args) {

//        List<CyclingDay> days = CyclingDayList.createCyclingDayList();
//        for ( CyclingDay day: days) {
//            System.out.println(day);
//        }
//        System.out.println(days.size());


        Integer year = selecionaAno();

        if (year == 1)
            exit(0);

        System.out.println();

        Integer month = selecionaMes(year);

        if (month == 1)
            exit(0);

        System.out.println();

        printInfo(year, month);

    }

    public static Integer selecionaAno() {

        while (true) {
            System.out.println();
            System.out.println("Anos registrados:");
            Set<Integer> years = repository.findYears();
            for (Integer year: years ) {
                System.out.println(year);
            }


            System.out.print("Escolha um ano (Digite 1 para sair):");
            Scanner scanner = new Scanner(System.in);
            Integer year = scanner.nextInt();

            if (year == 1)
                return 1;
            if (years.contains(year))
                return year;
            else {
                System.out.println();
                System.out.print("Ano incorreto ou não disponível. Tente novamente.");
                System.out.println();

            }
        }

    }

    public  static Integer selecionaMes(Integer year) {

        while (true) {
            System.out.println();
            System.out.printf("Meses de %d registrados:%n", year);
            List<CyclingDay> cyclingDays = repository.findByYear(year);
            Set<Month> months = new HashSet<>();
            for (CyclingDay cyclingDay : cyclingDays) {
                months.add(cyclingDay.getDate().getMonth());
            }
            months.forEach(
                    month -> {
                        System.out.print(month.getValue());
                        System.out.printf(" - %s%n", month);
                    }
            );
            System.out.print("Digite o número do mes(Digite 1 para sair):");
            Scanner scanner = new Scanner(System.in);
            int month = scanner.nextInt();

            if (month == 1)
                return 1;

            boolean isMonthValid = !(month > 12 || month < 1);

            if (isMonthValid) {
                if (months.contains(Month.of(month))) {
                    return month;
                }
                else {
                    System.out.println();
                    System.out.print("Mês incorreto ou não disponível. Tente novamente.");
                    System.out.println();
                }

            }
            else {
                System.out.println();
                System.out.print("Mês incorreto ou não disponível. Tente novamente.");
                System.out.println();

            }
        }
    }

    public  static void printInfo(Integer year, Integer month) {
        List<CyclingDay> cyclingDays = repository.findByMonthOfYear(LocalDate.of(year, month, 1));
        Util.printFormattedList(cyclingDays);

        System.out.println();
        System.out.println("Estatísticas do mês:");
        System.out.println(MonthStats.stats(cyclingDays));
    }

}
