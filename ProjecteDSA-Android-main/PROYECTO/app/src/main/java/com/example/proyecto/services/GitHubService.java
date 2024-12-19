package com.example.proyecto.services;

import com.example.proyecto.models.GitHubUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {
    @GET("users/{username}")
    Call<GitHubUser> getUser(@Path("username") String username);
}