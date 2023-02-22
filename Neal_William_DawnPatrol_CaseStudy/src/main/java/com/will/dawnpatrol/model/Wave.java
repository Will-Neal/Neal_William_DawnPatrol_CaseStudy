package com.will.dawnpatrol.model;

import java.util.Objects;

/**
 * @author willw
 * POJO whose main purpose is to hold data returned from the GenerateWave function in the SessionController.
 * Contains 3 doubles max, min and average. 
 */
public class Wave {

    double max;
    double min;
    double avg;

    public Wave() {
    }

    public Wave(double max, double min, double avg) {
        this.max = max;
        this.min = min;
        this.avg = avg;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wave wave = (Wave) o;
        return Double.compare(wave.max, max) == 0 && Double.compare(wave.min, min) == 0 && Double.compare(wave.avg, avg) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min, avg);
    }

    @Override
    public String toString() {
        return "Wave{" +
                "max=" + max +
                ", min=" + min +
                ", avg=" + avg +
                '}';
    }
}
