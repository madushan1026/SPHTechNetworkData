package com.kasundesilva.sphtechnetworkdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

public class DataUsageInfoActivity extends AppCompatActivity {

    private RecyclerView mDataInfoRecyclerView;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_usage_info);

        mDataInfoRecyclerView = findViewById(R.id.data_info_recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);
    }
}
