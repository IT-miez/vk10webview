package com.example.webbrowser;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    WebView web;
    TextView text;
    EditText input;
    ImageButton button;
    ImageButton buttonRefresh;
    ImageButton buttonBack;
    ImageButton buttonNext;
    String previous;
    String next;
    String current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        web = findViewById(R.id.webb);
        button = findViewById(R.id.imageButton);
        buttonRefresh = findViewById(R.id.imageButton2);
        buttonBack = findViewById(R.id.imageButton3);
        buttonNext = findViewById(R.id.imageButton4);
        web.setWebViewClient(new WebViewClient());

        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://www.google.fi");
        input = (EditText) findViewById(R.id.editTextTextPersonName);

    }


    public void searchBar(View v){
        String s = "http://";
        String s2 = input.getText().toString();
        String s3 = s + s2;
        System.out.println(s3);
        previous = web.getUrl();
        web.loadUrl(s3);
    }

    public void refreshURL(View v){
        web.loadUrl(web.getUrl());
    }

    public void goBack(View v){
        next = web.getUrl();
        web.loadUrl(previous);
    }

    public void goNext(View v){
        web.loadUrl(next);
    }

}