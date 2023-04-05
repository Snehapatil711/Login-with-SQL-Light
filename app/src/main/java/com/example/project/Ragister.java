package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ragister extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ragister);
        EditText ed1 = (EditText) findViewById(R.id.RUserId);
        EditText ed2 = (EditText) findViewById(R.id.RPassword);
        EditText ed3 = (EditText) findViewById(R.id.RRepassword);
        EditText ed4 = (EditText) findViewById(R.id.RDate);
        Button btn = (Button) findViewById(R.id.RButton);

        DB = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ed1.getText().toString();
                String password = ed2.getText().toString();
                String repassword = ed3.getText().toString();
                String date = ed4.getText().toString();
                if(user.equals("")|| password.equals("")|| repassword.equals("")|| date.equals(""))
                    Toast.makeText(Ragister.this, "Please enter all the filds", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(repassword)) {
                        Boolean checkeuser = DB.checkuserid(user);
                        if (checkeuser == false) {
                            Boolean insert = DB.insertData(user, password, date);
                            if (insert == true) {
                                Toast.makeText(Ragister.this, "Ragister Succesfully", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(Ragister.this, MainActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(Ragister.this, "Registation fails", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Ragister.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(Ragister.this, "Password not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}