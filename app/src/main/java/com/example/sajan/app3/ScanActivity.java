package com.example.sajan.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.Result;
import android.content.Intent;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView mScannerView;
    public static final String EXTRA_MESSAGE = "com.example.MESSAGE";
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result rawResult) {

       //Log.v("tag", rawResult.getText()); // Prints scan results
       // Log.v("tag", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        //MainActivity.tvresult.setText(rawResult.getText());

        Intent intent=new Intent(ScanActivity.this,Main2Activity.class);

        String message=rawResult.getText().toString();

        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);






    }
}
