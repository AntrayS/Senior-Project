package com.example.easymeets.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.easymeets.DAO.GroupDAO;
import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.R;
import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public static User activeUser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);



        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);




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