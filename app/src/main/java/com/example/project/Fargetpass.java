package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Fargetpass extends AppCompatActivity {

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fargetpass);

        EditText ed1 = (EditText) findViewById(R.id.UserId);
        /*EditText ed2 = (EditText) findViewById(R.id.Password);
        EditText ed3 = (EditText) findViewById(R.id.RRepassword);*/
        Button btn = (Button) findViewById(R.id.Submit);
        DB = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=ed1.getText().toString();
                Boolean checkuser=DB.checkuserid(user);
                if (checkuser==true){
                    Intent intent=new Intent(getApplicationContext(),Fargetpass2.class);
                    intent.putExtra("userid",user);
                    startActivity(intent);
                } else {
                    Toast.makeText(Fargetpass.this, "User does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}