package com.example.sajan.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void openscan(View view) {
        startActivity(new Intent(this,ScanActivity.class));
    }
    public void logout(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

}
