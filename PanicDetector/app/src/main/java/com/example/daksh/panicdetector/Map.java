package com.example.daksh.panicdetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Map extends AppCompatActivity {

    WebView webView;
    public static String SITE_URL = "http://noobly-hallows.westus.cloudapp.azure.com/codefundo/map/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_map);

        webView = (WebView)findViewById(R.id.webview_map);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(SITE_URL);

        WebSettings webSettings =   webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
