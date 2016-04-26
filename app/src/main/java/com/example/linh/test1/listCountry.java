package com.example.linh.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class listCountry extends AppCompatActivity {
    private countryListAdapter adapter;
    List<country> mCountry;
    country testCounty;

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
        readDataFromXML();
    }

    final View.OnClickListener bb = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
        }

    };


    private void readDataFromXML() {
        XmlPullParserFactory pullParserFactory;
//        ListView lv = (ListView) findViewById(R.id.ll);
//        testCounty = new country("USA", "US", "us.png");
//        mCountry.add(testCounty);
//        adapter = new countryListAdapter(getApplicationContext(), mCountry);
//        lv.setAdapter(adapter);
        try {
            pullParserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = pullParserFactory.newPullParser();
            InputStream in_s = getApplicationContext().getAssets().open("@string/");
//            parser= getResources().getXml(R.xml.contryinfo);
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in_s, null);

            getResources().getString();
            parserXML(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void parserXML(XmlPullParser parser) throws XmlPullParserException, IOException {
        int eventType = parser.getEventType();
        country currentCountry = null;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = null;
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    name = parser.getName();
                    if (name == "country") {
                        currentCountry = new country();
                    } else if (currentCountry != null) {
                        if (name == "name") {
                            currentCountry.setName(parser.nextText());
                        } else if (name == "code") {
                            currentCountry.setCode(parser.nextText());
                        } else if (name == "img") {
                            currentCountry.setImg(parser.nextText());
                        }
                    }
                    break;
                case XmlPullParser.END_TAG:
                    name = parser.getName();
                    if (name.equalsIgnoreCase("country") && currentCountry != null) {
                        mCountry.add(currentCountry);
                    }
            }
            eventType = parser.next();
        }
        ListView lv = (ListView) findViewById(R.id.ll);
        adapter = new countryListAdapter(getApplicationContext(), mCountry);
        lv.setAdapter(adapter);
    }
}




