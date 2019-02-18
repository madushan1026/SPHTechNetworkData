package com.kasundesilva.sphtechnetworkdata.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kasundesilva.sphtechnetworkdata.R;
import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;

import java.util.List;

public class DataInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AnnualDataInfo> mAnnualData;
    private Context mContext;


    public DataInfoAdapter(Context context, List<AnnualDataInfo> nicePlaces) {
        mAnnualData = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.annual_data_card, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((ViewHolder) viewHolder).mYear.setText(mAnnualData.get(i).getYear());
        ((ViewHolder) viewHolder).mUsage.setText(mAnnualData.get(i).getAnnualUsage());

    }

    @Override
    public int getItemCount() {
        return mAnnualData.size();
    }

    public void setmAnnualData(List<AnnualDataInfo> mAnnualData) {
        this.mAnnualData = mAnnualData;
    }


    // View holder class
    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mYear;
        private TextView mUsage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mYear = itemView.findViewById(R.id.year_text);
            mUsage = itemView.findViewById(R.id.usage_text);
        }
    }
}
