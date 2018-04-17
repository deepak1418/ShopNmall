package com.example.sajan.app3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {
    private static final String URL_PRODUCTS = "http://196995cf.ngrok.io/Api.php";
    List<Product> productList;
    RecyclerView recyclerView;
    private RequestQueue mreq;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();

        mreq= Volley.newRequestQueue(this);

        loadProducts();
    }
    public void openpay(View view) {
        startActivity(new Intent(this,Main4Activity.class));
    }
    private void loadProducts() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Intent intent=getIntent();

                            String message=intent.getStringExtra(ScanActivity.EXTRA_MESSAGE);
                            int in2 = new Integer(message.toString());

                            JSONArray array = new JSONArray(response);
                            //int c=0;
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                if (product.getInt("id") == in2) {

         productList.add(new Product(
                 product.getInt("id"),
                 product.getString("title"),
                 product.getString("shortdesc"),
                 product.getDouble("rating"),
                 product.getInt("price"),
                 product.getString("image"),
                 product.getString("description")
         ));

     }}ProductsAdapter adapter = new ProductsAdapter(Main2Activity.this, productList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
