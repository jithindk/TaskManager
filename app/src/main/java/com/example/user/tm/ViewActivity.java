package com.example.user.tm;

import android.support.v7.app.AppCompatActivity;

import com.example.user.tm.adapters.TaskAdapter;
import com.example.user.tm.models.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private List<Task> taskList = new ArrayList<>();
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference("task");
        recyclerView = findViewById(R.id.recyclerView);
        taskAdapter = new TaskAdapter(taskList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(taskAdapter);
        fetchData();

    }

    private void fetchData(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    taskList.clear();
                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                        Task task=snapshot.getValue(Task.class);
                        taskList.add(task);
                    }
                    taskAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}