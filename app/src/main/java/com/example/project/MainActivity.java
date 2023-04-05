package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed1 = (EditText) findViewById(R.id.UserId);
        EditText ed2 = (EditText) findViewById(R.id.Password);
        Button btn = (Button) findViewById(R.id.Loginbtn);
        Button btn1 = (Button) findViewById(R.id.Registerbtn);
        Button btn2 = (Button) findViewById(R.id.Fargetpassbtn);
        DB = new DBHelper(this);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = ed1.getText().toString();
                String password = ed2.getText().toString();

                if(user.equals("")||password.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all the filds", Toast.LENGTH_SHORT).show();
                else{
                    Boolean check = DB.checkuseridpassword(user, password);
                    if(check == true){
                        Toast.makeText(MainActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,Login.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "New User Please Register First", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Ragister.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Fargetpass.class);
                startActivity(i);
            }
        });
    }
}