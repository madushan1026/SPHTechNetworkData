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
import retrofit2.Retrofit;

public class DataUsageRepository {

    private static DataUsageRepository instance;
    private ArrayList<AnnualDataInfo> dataSet = new ArrayList<>();

    private GovDataService mGovDataService;


    public static DataUsageRepository getInstance(){
        if(instance == null){
            instance = new DataUsageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<AnnualDataInfo>> getAnnualUsageData(){
        setAnnualUsageData();
        MutableLiveData<List<AnnualDataInfo>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setAnnualUsageData(){

        mGovDataService = APIClient.getClient().create(GovDataService.class);
        Call<UsageDataPojo> call = mGovDataService.getUsageData();
        call.enqueue(new Callback<UsageDataPojo>() {
            @Override
            public void onResponse(Call<UsageDataPojo> call, Response<UsageDataPojo> response) {

               List<UsageDataPojo.Record> recodes = response.body().getResult().getRecords();

                for(UsageDataPojo.Record r: recodes){
                    System.out.println(r.getQuarter());
                    System.out.println(r.getVolumeOfMobileData());
                }
            }

            @Override
            public void onFailure(Call<UsageDataPojo> call, Throwable t) {
                System.out.println("XXXXXXXXXXXXX");
            }
        });

        dataSet.add(
                new AnnualDataInfo("2018",1.23,2.33,1.2,2.3)
        );

        dataSet.add(
                new AnnualDataInfo("2017",1.23,2.33,1.2,2.3)
        );

        dataSet.add(
                new AnnualDataInfo("2016",1.23,2.33,1.2,2.3)
        );

        dataSet.add(
                new AnnualDataInfo("2015",1.23,2.33,1.2,2.3)
        );

        dataSet.add(
                new AnnualDataInfo("2014",1.23,2.33,1.2,2.3)
        );

    }


}
