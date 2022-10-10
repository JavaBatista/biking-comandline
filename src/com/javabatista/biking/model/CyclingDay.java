package com.javabatista.biking.model;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class CyclingDay {
    private LocalDate date;
    private Instant startTime;
    private Instant finishTime;
    private LocalTime cyclingTime;
    private Double distance;
    private Double odometer;
    private Double maxSpeed;
    private Double avgSpeed;
    private WindCondition windCondition;
    private String comments;
    private Duration duration;
    private Double cyclingQuality;

    public LocalDate getDate() {
        return date;
    }

    public Duration getDuration() {
        return Duration.between(startTime, finishTime);
    }

    public Double getCyclingQuality() {
        return distance * avgSpeed;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Instant finishTime) {
        this.finishTime = finishTime;
    }

    public LocalTime getCyclingTime() {
        return cyclingTime;
    }

    public void setCyclingTime(LocalTime cyclingTime) {
        this.cyclingTime = cyclingTime;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getOdometer() {
        return odometer;
    }

    public void setOdometer(Double odometer) {
        this.odometer = odometer;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public WindCondition getWindCondition() {
        return windCondition;
    }

    public void setWindCondition(WindCondition windCondition) {
        this.windCondition = windCondition;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
