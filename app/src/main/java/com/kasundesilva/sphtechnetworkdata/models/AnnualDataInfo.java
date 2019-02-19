package com.kasundesilva.sphtechnetworkdata.models;

public class AnnualDataInfo {

    private double q1Usage;
    private double q2Usage;
    private double q3Usage;
    private double q4Usage;
    private String year;
    private String downTrendQuatre;

    public AnnualDataInfo() {
        this.q1Usage = 0;
        this.q2Usage = 0;
        this.q3Usage = 0;
        this.q4Usage = 0;
        this.downTrendQuatre = "";
    }

    public AnnualDataInfo(String year) {
        this.year = year;
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
        return String.format("%.4f", q1Usage + q2Usage + q3Usage + q4Usage);
    }

    public boolean isDecreased() {
        if (q1Usage > q2Usage){
            downTrendQuatre = "Q2";
            return true;
        }

        if (q2Usage > q3Usage)
        {
            downTrendQuatre = "Q3";
            return true;
        }

        if (q3Usage > q4Usage)
        {
            downTrendQuatre = "Q4";
            return true;
        }

        return false;
    }

    public String getDownTredingQuater() {
        return downTrendQuatre;
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
