package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername = findViewById(R.id.editTextUsername);
    }

    public void searchUser(View view) {
        String username = editTextUsername.getText().toString();
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}