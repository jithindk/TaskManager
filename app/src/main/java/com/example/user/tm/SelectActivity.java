package com.example.user.tm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity {

    private Button createb;
    private Button viewb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        createb=findViewById(R.id.create);
        viewb=findViewById(R.id.view);

        createb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create= new Intent(SelectActivity.this,CreateActivity.class);
                startActivity(create);
            }
        });

        viewb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view= new Intent(SelectActivity.this,ViewActivity.class);
                startActivity(view);
            }
        });
    }
}
