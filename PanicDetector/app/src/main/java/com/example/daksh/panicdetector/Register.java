package com.example.daksh.panicdetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Register extends AppCompatActivity {

    WebView webView;
    private static final String SITE_URL = "http://noobly-hallows.westus.cloudapp.azure.com/codefundo/signup/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView)findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient()) ;
        webView.loadUrl(SITE_URL);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}
