package com.kasundesilva.sphtechnetworkdata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.kasundesilva.sphtechnetworkdata.adapters.DataInfoAdapter;
import com.kasundesilva.sphtechnetworkdata.models.AnnualDataInfo;
import com.kasundesilva.sphtechnetworkdata.viewmodels.DataUsageViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataUsageInfoActivity extends AppCompatActivity {

    private RecyclerView mDataInfoRecyclerView;
    private DataInfoAdapter mAdapter;
    private ProgressBar mProgressBar;
    private DataUsageViewModel mDataUsageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_usage_info);

        mDataInfoRecyclerView = findViewById(R.id.data_info_recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);

        mDataUsageViewModel = ViewModelProviders.of(this).get(DataUsageViewModel.class);

        mDataUsageViewModel.getAnnualData().observe(this, new Observer<List<AnnualDataInfo>>() {
            @Override
            public void onChanged(@Nullable List<AnnualDataInfo> annualDataInfo) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        mAdapter = new DataInfoAdapter(this, mDataUsageViewModel.getAnnualData().getValue() );
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mDataInfoRecyclerView.setLayoutManager(linearLayoutManager);
        mDataInfoRecyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }
}
