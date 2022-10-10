package com.javabatista.biking.domain;

import com.javabatista.biking.Util;

import java.time.Duration;
import java.time.LocalDate;

public class CyclingStats {
    private LocalDate date;
    private Integer totalDays;
    private Double totalDistance;
    private Duration totalTime;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Duration totalTime) {
        this.totalTime = totalTime;
    }

    public CyclingStats(LocalDate date, Integer totalDays, Double totalDistance, Duration totalTime) {
        this.date = date;
        this.totalDays = totalDays;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    @Override
    public String toString() {
        return "CyclingStats{" +
                "totalDays=" + totalDays +
                ", totalDistance=" + totalDistance + " Km"+
                ", totalTime=" + Util.durationToString(totalTime) +
                '}';
    }
}
