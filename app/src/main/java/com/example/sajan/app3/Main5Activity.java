package com.example.sajan.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }
    public void opagain(View view) {
        startActivity(new Intent(this,Main3Activity.class));
    }
    public void logout(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
