package com.example.easymeets.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.easymeets.Activities.MainActivity;
import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.R;
import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.User;
import com.example.easymeets.Activities.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         Button login = findViewById(R.id.login);
         Button register = findViewById(R.id.register);
         login.setOnClickListener(this);
         register.setOnClickListener(this);
         if(MainActivity.activeUser != null){
             Login();
         }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login:
                Login();
                break;
            default:
                Register();
        }
    }

    public void Login(){
        EditText username = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        User user = AppDatabase.getDatabase(getApplicationContext()).userDao().getByName(username.getText().toString());
        if(MainActivity.activeUser == null && (user == null || !user.checkPassword(pass.getText().toString()))){
            Toast t = Toast.makeText(this,"Username or password is incorrect",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            MainActivity.activeUser=user;
            Intent switchActivityIntent = new Intent(this,GRoupActivity2.class);
            startActivity(switchActivityIntent);
        }
    }
    public void Register(){
        EditText username = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        if(AppDatabase.getDatabase(getApplicationContext()).userDao().getByName(username.getText().toString()) == null){
            User user = new User(username.getText().toString(),pass.getText().toString());
            AppDatabase.getDatabase(getApplicationContext()).userDao().insertUser(user);
            Toast t =  Toast.makeText(this,"Account created!",Toast.LENGTH_SHORT);
            t.show();
        }
        else{
            Toast t =  Toast.makeText(this,"Username already taken",Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
