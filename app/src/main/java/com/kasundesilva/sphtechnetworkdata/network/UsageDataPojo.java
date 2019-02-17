package com.kasundesilva.sphtechnetworkdata.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsageDataPojo {

    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }



    public class Result{

        @SerializedName("records")
        @Expose
        private List<Record> records = null;

        public List<Record> getRecords() {
            return records;
        }

        public void setRecords(List<Record> records) {
            this.records = records;
        }

    }

    public class Record {

        @SerializedName("volume_of_mobile_data")
        @Expose
        private String volumeOfMobileData;
        @SerializedName("quarter")
        @Expose
        private String quarter;
        @SerializedName("_id")
        @Expose
        private Integer id;

        public String getVolumeOfMobileData() {
            return volumeOfMobileData;
        }

        public void setVolumeOfMobileData(String volumeOfMobileData) {
            this.volumeOfMobileData = volumeOfMobileData;
        }

        public String getQuarter() {
            return quarter;
        }

        public void setQuarter(String quarter) {
            this.quarter = quarter;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }
}
