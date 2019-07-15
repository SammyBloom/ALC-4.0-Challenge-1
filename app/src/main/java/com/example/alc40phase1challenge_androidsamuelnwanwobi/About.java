package com.example.alc40phase1challenge_androidsamuelnwanwobi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import im.delight.android.webview.AdvancedWebView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitleTextColor(getResources().getColor(R.color.white));
//        myToolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("About ALC");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ProgressBar progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);

        WebView myWebView = findViewById(R.id.webview);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView.getSettings().setBuiltInZoomControls(true);
//        if (android.os.Build.VERSION.SDK_INT >= 19){
//            myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//            myWebView.getSettings().setDisplayZoomControls(false);
//        }

        myWebView.loadUrl("https://andela.com/alc/");

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                int id = item.getItemId();
                return super.onOptionsItemSelected(item);
        }
    }
}
