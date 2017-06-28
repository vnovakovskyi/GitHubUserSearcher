package com.dev.nova.githubusersearcher.activityes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dev.nova.githubusersearcher.API.GithubAPI;
import com.dev.nova.githubusersearcher.API.GithubRepo;
import com.dev.nova.githubusersearcher.API.GithubUser;
import com.dev.nova.githubusersearcher.Buffer;
import com.dev.nova.githubusersearcher.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    EditText toSearch;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toSearch = (EditText) findViewById(R.id.to_search);
    }

    public void onClick(View view) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GithubAPI githubUserAPI = retrofit.create(GithubAPI.class);

        switch (view.getId()) {
            case R.id.loadUserData:
                Call<GithubUser> callUser = githubUserAPI.getUser(String.valueOf(toSearch.getText()));
                callUser.enqueue(users);
                intent = new Intent(this, UsersViewActivity.class);
                break;

            case R.id.loadRepositories:
                Call<GithubRepo> callRepos = githubUserAPI.getRepos(String.valueOf(toSearch.getText()));
                callRepos.enqueue(repos);
                intent = new Intent(this, ReposViewActivity.class);
                break;
        }
    }

    Callback repos = new Callback<GithubRepo>() {

        @Override
        public void onResponse(Call<GithubRepo> call, Response<GithubRepo> response) {
            int code = response.code();
            if (code == 200) {
                GithubRepo repo = response.body();

                Buffer.repo = repo;

                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onFailure(Call<GithubRepo> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Did not work " + t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    Callback users = new Callback<GithubUser>() {

        @Override
        public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
            int code = response.code();
            if (code == 200) {
                GithubUser user = response.body();

                Buffer.user = user;

                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<GithubUser> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Nope", Toast.LENGTH_LONG).show();

        }
    };
}
