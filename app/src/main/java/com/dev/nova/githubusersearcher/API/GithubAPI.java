package com.dev.nova.githubusersearcher.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GithubAPI {

    String ENDPOINT = "https://api.github.com";

    @GET("/search/users")
    Call<GithubUser> getUser(@Query("q") String user);

    @GET("search/repositories")
    Call<GithubRepo> getRepos(@Query("q") String repo);
}
