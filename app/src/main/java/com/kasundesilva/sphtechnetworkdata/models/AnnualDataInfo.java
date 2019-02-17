package com.kasundesilva.sphtechnetworkdata.models;

public class AnnualDataInfo {

    private double q1Usage;
    private double q2Usage;
    private double q3Usage;
    private double q4Usage;
    private String year;

    public AnnualDataInfo(String year, double q1Usage, double q2Usage, double q3Usage, double q4Usage) {
        this.year = year;
        this.q1Usage = q1Usage;
        this.q2Usage = q2Usage;
        this.q3Usage = q3Usage;
        this.q4Usage = q4Usage;
    }

    public AnnualDataInfo() {
        this.q1Usage = 0;
        this.q2Usage = 0;
        this.q3Usage = 0;
        this.q4Usage = 0;
    }


    // getters
    public String getYear() {
        return year;
    }

    public String getAnnualUsage() {
        return Double.toString(q1Usage + q2Usage + q3Usage + q4Usage);
    }

    public double getQ1Usage() {
        return q1Usage;
    }

    public double getQ2Usage() {
        return q2Usage;
    }

    public double getQ3Usage() {
        return q3Usage;
    }

    public double getQ4Usage() {
        return q4Usage;
    }


    // setters
    public void setYear(String year) {
        this.year = year;
    }

    public void setQ1Usage(double q1Usage) {
        this.q1Usage = q1Usage;
    }

    public void setQ2Usage(double q2Usage) {
        this.q2Usage = q2Usage;
    }

    public void setQ3Usage(double q3Usage) {
        this.q3Usage = q3Usage;
    }

    public void setQ4Usage(double q4Usage) {
        this.q4Usage = q4Usage;
    }


}
