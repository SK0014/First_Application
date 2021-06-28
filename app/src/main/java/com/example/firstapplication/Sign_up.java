package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    EditText edt_uname;
    EditText edt_pass;
    EditText edt_Fullname;
    EditText edt_Email;
    EditText edt_Cno;
    EditText edt_Repass;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;

    Button btn_sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edt_uname=findViewById(R.id.u_name);
        edt_pass=findViewById(R.id.pass);
        edt_Fullname=findViewById(R.id.edt_name);
        edt_Email=findViewById(R.id.edt_mail);
        edt_Cno=findViewById(R.id.edt_no);
        edt_Repass=findViewById(R.id.edt_repass);
        r1=findViewById(R.id.edt_radio1);
        r2=findViewById(R.id.edt_radio2);
        r3=findViewById(R.id.edt_radio3);
        c1=findViewById(R.id.edt_check1);
        c2=findViewById(R.id.edt_check2);
        c3=findViewById(R.id.edt_check3);
        btn_sign= findViewById(R.id.btn_up);
        btn_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_uname.getText().toString().isEmpty()||edt_pass.getText().toString().isEmpty()||edt_Fullname.getText().toString().isEmpty()
                ||edt_Email.getText().toString().isEmpty()||edt_Cno.getText().toString().isEmpty()||edt_Repass.getText().toString().isEmpty()
                ||(r1.isChecked()&&r2.isChecked()&&r3.isChecked())||(c1.isChecked()&&c2.isChecked()&&c3.isChecked())){

                    Toast.makeText(getApplicationContext(),"Please enter all details",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    String id_sign = edt_uname.getText().toString();
                    String pass_sign = edt_pass.getText().toString();
                    intent.putExtra("username", id_sign);
                    intent.putExtra("password", pass_sign);
                    startActivity(intent);
                }
            }
        });


    }
}