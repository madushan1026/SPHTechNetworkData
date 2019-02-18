package com.kasundesilva.sphtechnetworkdata.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;
import com.kasundesilva.sphtechnetworkdata.network.APIClient;
import com.kasundesilva.sphtechnetworkdata.network.GovDataService;
import com.kasundesilva.sphtechnetworkdata.network.UsageDataPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataUsageRepository {

    private static DataUsageRepository instance;
    private ArrayList<AnnualDataInfo> dataSet = new ArrayList<>();

    private GovDataService mGovDataService;


    public static DataUsageRepository getInstance() {
        if (instance == null) {
            instance = new DataUsageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<AnnualDataInfo>> getAnnualUsageData() {

        final MutableLiveData<List<AnnualDataInfo>> data = new MutableLiveData<>();

        mGovDataService = APIClient.getClient().create(GovDataService.class);
        Call<UsageDataPojo> call = mGovDataService.getUsageData();

        call.enqueue(new Callback<UsageDataPojo>() {
            @Override
            public void onResponse(Call<UsageDataPojo> call, Response<UsageDataPojo> response) {

                List<UsageDataPojo.Record> recodes = response.body().getResult().getRecords();

                // generate model data
                String prvYear = null;
                AnnualDataInfo aData = new AnnualDataInfo();

                for (UsageDataPojo.Record r : recodes) {

                    String[] yearNquater = r.getQuarter().split("-");

                    // filter year for above 2008
                    if(Integer.parseInt(yearNquater[0]) < 2008)
                        continue;

                    if (prvYear != null && !prvYear.equals(yearNquater[0])) {
                        dataSet.add(aData);
                        aData = new AnnualDataInfo();
                    }
                    aData.setYear(yearNquater[0]);

                    switch (yearNquater[1]) {
                        case "Q1":
                            aData.setQ1Usage(Double.parseDouble(r.getVolumeOfMobileData()));
                            break;
                        case "Q2":
                            aData.setQ2Usage(Double.parseDouble(r.getVolumeOfMobileData()));
                            break;
                        case "Q3":
                            aData.setQ3Usage(Double.parseDouble(r.getVolumeOfMobileData()));
                            break;
                        case "Q4":
                            aData.setQ4Usage(Double.parseDouble(r.getVolumeOfMobileData()));
                            break;
                        default:

                    }

                    prvYear = yearNquater[0];
                }
                dataSet.add(aData);
                data.setValue(dataSet);
            }

            @Override
            public void onFailure(Call<UsageDataPojo> call, Throwable t) {
                data.setValue(null);
            }

        });

        return data;

    }
}
