package com.example.sajan.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }


        public void onplace(View view) {
            // MainActivity.price_sum=Integer.parseInt(holder.t1.getText().toString());

            Toast.makeText(Main4Activity.this, "Your is Order placed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Main5Activity.class));


        }


}
