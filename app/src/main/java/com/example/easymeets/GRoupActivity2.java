package com.example.easymeets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class GRoupActivity2 extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group2);
        Button button = findViewById(R.id.button6);

    }

    @Override
    public void onClick(View v) {
        EditText editText = (EditText)findViewById(R.id.textEdit);
        editText.setText("Hello!");
    }
}