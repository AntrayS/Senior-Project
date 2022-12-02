package com.example.easymeets.Adaptor;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymeets.Activities.MainActivity;
import com.example.easymeets.R;
import com.example.easymeets.database.AppDatabase;
import com.example.easymeets.entities.Group;


public class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView Name,Topics;
    Button Join;
    public GroupViewHolder(@NonNull View itemView) {
        super(itemView);
        Name = itemView.findViewById(R.id.Name);
        Topics = itemView.findViewById(R.id.Topic);
        Join = itemView.findViewById(R.id.Join);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.Join && Join.getText().toString().equals("Join")) {
            join(Join);
        }
        else if(v.getId() == R.id.Join && Join.getText().toString().equals("Leave")){
            //Leave
        }
        else{

        }
    }

    public void join(Button b){
        System.out.println("clicked");
        b.setText("Leave");
        Group group = AppDatabase.getDatabase(itemView.getContext()).groupDao().getByName(Name.getText().toString());
        group.addUser(MainActivity.activeUser);
    }
}
