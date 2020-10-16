package com.vimal.campussathi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website=(WebView)findViewById(R.id.webview_CampusSathi);
        website.setInitialScale(0);
        WebSettings webSettings=website.getSettings();
        webSettings.setJavaScriptEnabled(true);
        website.getSettings().setLoadWithOverviewMode(true);
        website.getSettings().setUseWideViewPort(true);
        website.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        website.setScrollbarFadingEnabled(false);
        website.loadUrl("http://campussathi.in/");
        website.setWebViewClient(new WebViewClient());


    }
}