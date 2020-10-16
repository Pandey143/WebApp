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
        website.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String sitelink, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(sitelink));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "download");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);

            }
        });


    }

    @Override
    public void onBackPressed() {
        if(website.canGoBack()){
            website.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}