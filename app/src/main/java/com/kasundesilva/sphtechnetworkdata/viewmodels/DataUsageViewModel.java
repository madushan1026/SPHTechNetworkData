package com.kasundesilva.sphtechnetworkdata.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;
import com.kasundesilva.sphtechnetworkdata.repositories.DataUsageRepository;

import java.util.List;

public class DataUsageViewModel extends AndroidViewModel {

    private MutableLiveData<List<AnnualDataInfo>> mAnnualData;
    private DataUsageRepository mRepo;

    public DataUsageViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(){
        if(mAnnualData != null){
            return;
        }

        mRepo = DataUsageRepository.getInstance(getApplication());
        mAnnualData = mRepo.getAnnualUsageData();
    }

    public LiveData<List<AnnualDataInfo>> getAnnualData(){
        return mAnnualData;
    }
}
