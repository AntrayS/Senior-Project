package com.example.easymeets;

import android.os.Bundle;
import android.util.Log;

import com.example.easymeets.DAO.UserDAO;
import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.Group;
import com.example.easymeets.entities.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.example.easymeets.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"UserDatabase").build();
        UserDAO userDao = db.userDao();

        ArrayList<String> L = new ArrayList<String>();
        L.add("TestTopic");

        Group group1 = new Group("TestGroup", L);
        Group group2 = new Group("TestGroup2",L);

        User user = new User("User","Pass");

    }
}