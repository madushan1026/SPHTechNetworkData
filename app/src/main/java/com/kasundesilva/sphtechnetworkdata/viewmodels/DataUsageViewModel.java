package com.kasundesilva.sphtechnetworkdata.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;

import java.util.List;

public class DataUsageViewModel extends ViewModel {

    private MutableLiveData<List<AnnualDataInfo>> mAnnualData;

    public LiveData<List<AnnualDataInfo>> getAnnualData(){
        return mAnnualData;
    }
}
