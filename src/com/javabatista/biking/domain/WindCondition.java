package com.javabatista.biking.domain;

public enum WindCondition {
    WEAK("Fraco"),
    MILD("Moderado"),
    HIGH("Forte");

    public final String label;

    WindCondition(String condition) {
        this.label = condition;
    }

    @Override
    public String toString() {
        return this.label;
    }


}
