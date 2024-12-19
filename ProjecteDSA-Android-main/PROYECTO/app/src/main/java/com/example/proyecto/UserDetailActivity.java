package com.example.proyecto;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto.models.GitHubUser;
import com.example.proyecto.services.GitHubService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserDetailActivity extends AppCompatActivity {
    private TextView textViewFollowers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        textViewFollowers = findViewById(R.id.textViewFollowers);

        String username = getIntent().getStringExtra("username");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        service.getUser(username).enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                if (response.isSuccessful()) {
                    GitHubUser user = response.body();
                    textViewFollowers.setText("Followers: " + user.getFollowers());
                } else {
                    Toast.makeText(UserDetailActivity.this, "Failed to fetch user details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
                Toast.makeText(UserDetailActivity.this, "Failed to fetch user details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}