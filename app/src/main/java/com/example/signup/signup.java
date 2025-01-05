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

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    EditText username, pwd;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.username);
        pwd = (EditText) findViewById(R.id.password);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = username.getText().toString();
                String userpwd = pwd.getText().toString();
                if (email.matches("")) {
                    Toast.makeText(signup.this, "Username cannot be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if (!isvalidpassword(userpwd)) {
                    Toast.makeText(signup.this, "Invalid Password", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(signup.this, signin.class);
                intent.putExtra("email",email);
                intent.putExtra("userpwd",userpwd);
                startActivity(intent);

            }
        });
    }

    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern special = Pattern.compile("^.*[@#$%^&*(){},.;/].*$");

    private boolean isvalidpassword(String userpwd) {

        if (userpwd.length() < 8) {
            return false;
        }
        if(!lowercase.matcher(userpwd).matches())
        {
            return false;
        }
        if(!uppercase.matcher(userpwd).matches())
        {
            return false;
        }
        if(!special.matcher(userpwd).matches())
        {
            return false;
        }if(!number.matcher(userpwd).matches())
        {
            return false;
        }


        return true;

    }

}