package com.dev.nova.githubusersearcher.activityes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dev.nova.githubusersearcher.LVAdapters.UsersLVAdapter;
import com.dev.nova.githubusersearcher.R;

public class UsersViewActivity extends AppCompatActivity{

    ListView usersLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_layout);

        usersLV = (ListView) findViewById(R.id.users_lv);
        usersLV.setAdapter(new UsersLVAdapter(this));
    }
}
