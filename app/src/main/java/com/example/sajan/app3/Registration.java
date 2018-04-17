package com.example.sajan.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    EditText u,e,p,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        u=(EditText)findViewById(R.id.user);
        p=(EditText)findViewById(R.id.pass);
        e=(EditText)findViewById(R.id.email);
        c=(EditText)findViewById(R.id.cpass);
    }
    public void openReg(View view)
    {
        String User = u.getText().toString();
        String Email = e.getText().toString();
        String Pass = p.getText().toString();
        String Cpass = c.getText().toString();
        String type = "Register";
        RegBack backgroundWorker = new RegBack(this);
        backgroundWorker.execute(type, User,Email,Pass,Cpass);
    }

}
