package com.dev.nova.githubusersearcher.activityes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dev.nova.githubusersearcher.LVAdapters.ReposLVAdapter;
import com.dev.nova.githubusersearcher.R;

public class ReposViewActivity extends AppCompatActivity {

    ListView reposLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repos_layout);

        reposLV = (ListView) findViewById(R.id.repos_lv);
        reposLV.setAdapter(new ReposLVAdapter(this));
    }
}