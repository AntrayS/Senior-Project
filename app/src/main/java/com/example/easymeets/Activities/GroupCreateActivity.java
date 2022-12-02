package com.example.easymeets.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easymeets.Adaptor.GroupAdaptor;
import com.example.easymeets.R;
import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.Group;

public class GroupCreateActivity  extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create);
        Button create = findViewById(R.id.btnCreate);
        create.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText name = findViewById(R.id.Name);
        EditText Topic = findViewById(R.id.Topic);
        Group group = new Group(name.getText().toString(),Topic.getText().toString());
        AppDatabase.getDatabase(getApplicationContext()).groupDao().addGroup(group);

        Toast t = Toast.makeText(getApplicationContext(),"Group created!", Toast.LENGTH_SHORT);
        t.show();
        Intent switchActivityIntent = new Intent(this,GRoupActivity2.class);
        startActivity(switchActivityIntent);
    }
}
