package com.example.user.tm.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.tm.R;
import com.example.user.tm.models.Task;
import java.util.List;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private List<Task> taskList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView date;
        public TextView desc;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            date = view.findViewById(R.id.date);
            desc = view.findViewById(R.id.desc);
        }
    }


    public TaskAdapter(List<Task> taskList) {

        this.taskList = taskList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_relative, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.title.setText(task.getTitle());
        holder.date.setText(task.getDate());
        holder.desc.setText(task.getDesc());

    }

    @Override
    public int getItemCount() {

        return taskList.size();
    }


}