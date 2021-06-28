package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edt_username;
    EditText edt_password;
    ImageButton btn_login;
    Button btn_SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_username=findViewById(R.id.user_name);
        edt_password=findViewById(R.id.pass_word);
        btn_login=(ImageButton)findViewById(R.id.btn_submit);
        btn_SignUp=findViewById(R.id.btn_sign_up);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_username.getText().toString().isEmpty()||edt_password.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter all details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent2 = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(intent2);
                }

            }
        });

        btn_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),Sign_up.class);
                startActivity(intent1);
            }
        });
        Intent intent = getIntent();
        String id = intent.getStringExtra("username");
        String pass_login = intent.getStringExtra("password");
        edt_username.setText(id);
        edt_password.setText(pass_login);

    }
}