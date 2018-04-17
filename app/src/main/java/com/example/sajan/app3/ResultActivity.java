package com.example.sajan.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends ScanActivity {
 public static TextView rs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        rs=(TextView)findViewById(R.id.tvresult);
        Intent intent=getIntent();
        String message=intent.getStringExtra(ScanActivity.EXTRA_MESSAGE);
        rs.setText(message);
    }

}
