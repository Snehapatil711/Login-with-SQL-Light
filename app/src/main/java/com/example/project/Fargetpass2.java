package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fargetpass2 extends AppCompatActivity {

    TextView username;
    EditText pass, repass;
    Button confirmpass;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fargetpass2);

        username = findViewById(R.id.textView1);
        pass = findViewById(R.id.Password);
        repass = findViewById(R.id.RRepassword);
        confirmpass = findViewById(R.id.Submit);
        DB = new DBHelper(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("userid"));

        confirmpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String password = pass.getText().toString();
                String repassword = repass.getText().toString();
                if (password.equals(repassword)) {

                    Boolean check_pass_update = DB.updatepassword(user, password);
                    if (check_pass_update == true) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        Toast.makeText(Fargetpass2.this, "Password Update Successfully...", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Fargetpass2.this, "Password Not Update", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Fargetpass2.this, "Password not matching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}