package com.kasundesilva.sphtechnetworkdata.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;
import com.kasundesilva.sphtechnetworkdata.repositories.DataUsageRepository;

import java.util.List;

public class DataUsageViewModel extends ViewModel {

    private MutableLiveData<List<AnnualDataInfo>> mAnnualData;
    private DataUsageRepository mRepo;

    public void init(){
        if(mAnnualData != null){
            return;
        }

        mRepo = DataUsageRepository.getInstance();
        mAnnualData = mRepo.getAnnualUsageData();
    }

    public LiveData<List<AnnualDataInfo>> getAnnualData(){
        return mAnnualData;
    }
}
