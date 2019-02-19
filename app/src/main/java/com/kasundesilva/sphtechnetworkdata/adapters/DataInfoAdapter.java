package com.kasundesilva.sphtechnetworkdata.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.kasundesilva.sphtechnetworkdata.R;
import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;

import java.util.List;

public class DataInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<AnnualDataInfo> mAnnualData;
    private Context mContext;


    public DataInfoAdapter(Context context, List<AnnualDataInfo> annualUsageData) {
        mAnnualData = annualUsageData;
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

        if (mAnnualData.get(i).isDecreased()) {
            ((ViewHolder) viewHolder).setDownTrendQuatre(mAnnualData.get(i).getDownTredingQuater());
            ((ViewHolder) viewHolder).mDownTrentButton.setVisibility(View.VISIBLE);
        } else
            ((ViewHolder) viewHolder).mDownTrentButton.setVisibility(View.GONE);


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
        private ImageButton mDownTrentButton;
        private String downTrendQuatre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mYear = itemView.findViewById(R.id.year_text);
            mUsage = itemView.findViewById(R.id.usage_text);
            mDownTrentButton = itemView.findViewById(R.id.down_trend_imagebutton);

            // setting dialog view to show info
            mDownTrentButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(mContext)
                            .setTitle("Usage Trends")
                            .setMessage("There is a decrease in " + downTrendQuatre)
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }
            });
        }

        public void setDownTrendQuatre(String downTrendQuatre) {
            this.downTrendQuatre = downTrendQuatre;
        }
    }
}
