package com.example.user.tm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CreateActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private  DatabaseReference myRef;
    private Button submit;
    private EditText eTitle;
    private EditText eDesc;
    private EditText eDate;
    private String date;
    private String title;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference("task");
        submit=findViewById(R.id.submit);
        eTitle=findViewById(R.id.title);
        eDesc=findViewById(R.id.desc);
        eDate=findViewById(R.id.date);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                title=eTitle.getText().toString().trim();
                desc=eDesc.getText().toString().trim();
                date=eDate.getText().toString().trim();
                HashMap<String, String> dataPush=new HashMap<String, String>();
                dataPush.put("title", title);
                dataPush.put("description", desc);
                dataPush.put("date", date);
                myRef.push().setValue(dataPush).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreateActivity.this, "Succesful", Toast.LENGTH_SHORT).show();
                            Intent create= new Intent(CreateActivity.this,ViewActivity.class);
                            startActivity(create);
                        }
                        else
                        {
                            Toast.makeText(CreateActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        }


                }});


            }
        });
    }
}
