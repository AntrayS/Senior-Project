package com.example.easymeets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.Group;

public class GroupCreate extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create);
        Button create = findViewById(R.id.btnCreate);

    }

    @Override
    public void onClick(View v) {
        EditText name = findViewById(R.id.Name);
        EditText Topic = findViewById(R.id.Topic);
        Group group = new Group(name.getText().toString(),Topic.getText().toString());
        AppDatabase.getDatabase(getApplicationContext()).groupDao().addGroup(group);
    }
}