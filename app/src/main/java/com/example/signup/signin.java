package com.example.signup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signin extends AppCompatActivity {
    EditText eusername, epwd;
    Button login;
    int count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);

        eusername = (EditText) findViewById(R.id.username);
        epwd = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
        String regemail = getIntent().getStringExtra("email");
        String regpwd = getIntent().getStringExtra("userpwd");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newemail = eusername.getText().toString();
                String newpwd = epwd.getText().toString();
                if (newpwd.equals(regpwd) && newemail.equals(regemail)) {
                    Toast.makeText(signin.this, "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(signin.this, welcome.class);
                    startActivity(intent);
                    eusername.setText("");
                    epwd.setText("");
                } else {
                    count++;
                    Toast.makeText(signin.this, "Login Failed " + count, Toast.LENGTH_LONG).show();
                    if (count == 3) {
                        login.setEnabled(false);
                        Toast.makeText(signin.this, "Login Failed " + count, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}