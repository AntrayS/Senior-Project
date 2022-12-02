package com.example.easymeets.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.easymeets.Adaptor.GroupAdaptor;
import com.example.easymeets.R;
import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.Group;
import com.example.easymeets.Activities.MainActivity;
import com.example.easymeets.entities.User;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class GRoupActivity2 extends AppCompatActivity implements View.OnClickListener{

    public static RecyclerView recyclerView;
    public static GroupAdaptor groupAdaptor;
    public static List<Group> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        User user = MainActivity.activeUser;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);
         recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button logOut = findViewById(R.id.Logout);
        Button Create = findViewById(R.id.Create);
        list = new ArrayList<Group>();
        list.add(new Group("TestGroup","Test"));
        list.add(new Group("EasyMeets","App Development"));
        list.add(new Group("One more Group","Stuff"));
        for(int i = 0; i < 3; i++){
            AppDatabase.getDatabase(getApplicationContext()).groupDao().addGroup(list.get(i));
        }
        logOut.setOnClickListener(this);
        Create.setOnClickListener(this);
        groupAdaptor = new GroupAdaptor(getApplicationContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(groupAdaptor);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Logout:
                Logout();
                break;
            case R.id.Create:
                Create();
                break;

        }
    }
    public void Logout(){
        MainActivity.activeUser=null;
        Intent switchActivityIntent = new Intent(this,MainActivity.class);
        startActivity(switchActivityIntent);
    }
    public void Create(){
        Intent switchActivityIntent = new Intent(this,GroupCreateActivity.class);
        startActivity(switchActivityIntent);
        groupAdaptor.notifyDataSetChanged();
    }
}