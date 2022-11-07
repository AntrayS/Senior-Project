package com.example.easymeets;

import android.content.Intent;
import android.os.Bundle;
<<<<<<< Updated upstream

import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.easymeets.databinding.ActivityMainBinding;

import java.util.ArrayList;
=======
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
>>>>>>> Stashed changes

import com.example.easymeets.R;
import com.example.easymeets.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);


<<<<<<< Updated upstream
=======
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
>>>>>>> Stashed changes



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button1:
                Toast.makeText(this, "EXIT  clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                switchToGeo();
                break;
            case R.id.button3:
                switchToGroup();
                break;
            case R.id.button4:
                Toast.makeText(this, "HOME  clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button5:
                switchToCalendar();
                break;

        }
    }

    private void switchToCalendar(){
        Intent switchActivityIntent = new Intent(this,CalendarActivity.class);
        startActivity(switchActivityIntent);
    }
    private void switchToGeo(){
        Intent switchActivityIntent = new Intent(this,MapsActivity2.class);
        startActivity(switchActivityIntent);
    }
    private void switchToGroup(){
        Intent switchActivityIntent = new Intent(this, LoginActivity.class);
        startActivity(switchActivityIntent);
    }
}