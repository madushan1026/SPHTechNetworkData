package com.kasundesilva.sphtechnetworkdata.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;

import java.util.ArrayList;
import java.util.List;

public class DataInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AnnualDataInfo> mAnnualData = new ArrayList<>();
    private Context mContext;


    public DataInfoAdapter(Context context, List<AnnualDataInfo> nicePlaces) {
        mAnnualData = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
