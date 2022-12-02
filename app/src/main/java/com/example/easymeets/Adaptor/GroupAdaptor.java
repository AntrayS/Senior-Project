package com.example.easymeets.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easymeets.R;
import com.example.easymeets.entities.Group;

import java.util.List;

public class GroupAdaptor extends RecyclerView.Adapter<GroupViewHolder> {
    Context context;
    public static List<Group> list;

    public GroupAdaptor(Context context, List<Group> list){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View groupViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_group_view,parent,false);
        return new GroupViewHolder(groupViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        Group data = list.get(position);
        holder.Name.setText(list.get(position).getGroupName());
        holder.Topics.setText(list.get(position).getTopics());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
