package com.javabatista.biking.service;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.domain.CyclingStats;

import java.util.List;

public class MonthStats {

    public static CyclingStats stats(List<CyclingDay> cyclingDays) {

        Integer size = cyclingDays.size();
        return new CyclingStats();
    }
}
