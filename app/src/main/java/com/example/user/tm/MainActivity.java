package com.example.user.tm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private Button login;
    private EditText usernameB;
    private EditText passwordB;
    private TextView fpassB;
    private TextView signupB;

    String username;
    String password;
    String rUsername="jithin";
    String rPassword="cittic";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.signin);
        usernameB=findViewById(R.id.username);
        passwordB=findViewById(R.id.password);
        fpassB=findViewById(R.id.fpass);
        signupB=findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=usernameB.getText().toString().toLowerCase().trim();
                password=passwordB.getText().toString().trim();
                if(username.equals(rUsername)&&password.equals(rPassword))
                {
                    login.setText("Logging In");
                    Toast.makeText(MainActivity.this, "Welcome Jithin", Toast.LENGTH_SHORT).show();
                    Intent secpage= new Intent(MainActivity.this,SelectActivity.class);
                    startActivity(secpage);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid User", Toast.LENGTH_SHORT).show();
                }
            }
        });
        fpassB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Please come after sometime", Toast.LENGTH_SHORT).show();
            }
        });
        signupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Program not that advanced", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
