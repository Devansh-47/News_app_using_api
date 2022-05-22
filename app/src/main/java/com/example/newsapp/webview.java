package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        String url=getIntent().getStringExtra("url");
        WebView wv=findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(url);
    }
}