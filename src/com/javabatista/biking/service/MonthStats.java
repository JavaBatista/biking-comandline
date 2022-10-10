package com.javabatista.biking.service;

import com.javabatista.biking.domain.CyclingDay;
import com.javabatista.biking.domain.CyclingStats;

import java.time.Duration;
import java.util.List;

public class MonthStats {

    public static CyclingStats stats(List<CyclingDay> cyclingDays) {

        Integer totalDays = cyclingDays.size();
        Double totalDistance  = 0.0;
        Duration totalTime  = Duration.ofHours(0);

        for (CyclingDay day: cyclingDays ) {
            totalDistance += day.getDistance();
            totalTime = totalTime.plus(day.getDuration());
        }

        return new CyclingStats(cyclingDays.get(0).getDate(), totalDays, totalDistance, totalTime);
    }
}
