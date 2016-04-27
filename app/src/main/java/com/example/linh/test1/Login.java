package com.example.linh.test1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Login extends AppCompatActivity {
    private validate va = new validate();
    Button loginButton = (Button) findViewById(R.id.loginButton);
    private GoogleApiClient client;
    String arlet = "Email or password is not correct";
    EditText edittextEmail = (EditText) findViewById(R.id.edittextEmail);
    EditText edittextPassword = (EditText) findViewById(R.id.edittextPassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginButton.setOnClickListener(checklogin);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    final View.OnClickListener checklogin = new View.OnClickListener() {
        public void onClick(View v) {
            TextView msg = (TextView) findViewById(R.id.dialog);
            boolean validateEmail = va.validateEmail(edittextEmail.getText().toString());
            boolean validatePassword = va.validatePassword(edittextPassword.getText().toString());
            if (validateEmail & validatePassword) {
                Intent intent = new Intent(getApplicationContext(), listCountry.class);
                intent.putExtra("email", edittextEmail.getText().toString());
                startActivity(intent);
            } else {
                msg.setText(arlet);
            }
        }

    };

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.linh.test1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Login Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.linh.test1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
