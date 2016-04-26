package com.example.linh.test1;

import android.content.Intent;
import android.content.res.Resources;
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
   public int[] countryImg = {0,0,0};
    private void fillDataListViewCountry() {
        Resources rs = getResources();
        String[] countryName = rs.getStringArray(R.array.country_name);
        String[] countryCode = rs.getStringArray(R.array.country_code);
        getCountryImgCode(countryCode);
        adapter = new countryListAdapter(getApplicationContext(),countryName,countryCode,countryImg);
        ListView listViewCountry = (ListView) findViewById(R.id.ll);
        listViewCountry.setAdapter(adapter);

    }

    private void getCountryImgCode(String[] countryCode) {
        int i = 0;
        Resources res = getResources();
        countryImg[0] = res.getIdentifier("us","drawable",getPackageName());
        for ( i = 0  ; i < countryCode.length; i++)
        {
            countryImg[i] = res.getIdentifier(countryCode[i],"drawable",getPackageName());
        }



    }

    final View.OnClickListener bb = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }

    };



}




