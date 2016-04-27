package com.example.linh.test1;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

public class listCountry extends AppCompatActivity {
    private countryListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_country);
        TextView sEmail = (TextView) findViewById(R.id.showEmail);
        Button backButton = (Button) findViewById(R.id.bBack);
        backButton.setOnClickListener(bb);
        Bundle extras = getIntent().getExtras();
        String email;
        if (extras == null) {
            email = null;
        } else {
            email = extras.getString("email");
        }
        sEmail.setText(email);
        fillDataListViewCountry();

    }
   public int[] countryImg = {0,0,0} ;
    private void fillDataListViewCountry() {
        Resources rs = getResources();
        String[] countryName = rs.getStringArray(R.array.country_name);
        String[] countryCode = rs.getStringArray(R.array.country_code);
        TypedArray imgs = getResources().obtainTypedArray(R.array.country_image_falg);
        adapter = new countryListAdapter(getApplicationContext(),countryName,countryCode,imgs);
        ListView listViewCountry = (ListView) findViewById(R.id.ll);
        listViewCountry.setAdapter(adapter);

    }

    final View.OnClickListener bb = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }

    };



}




