package com.example.kaushik.pictentc;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class pdf_view extends AppCompatActivity {
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        final WebView webView;
        webView=(WebView)findViewById(R.id.webview);
        uri=getIntent().getData();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(uri.toString());
        Toast.makeText(getApplicationContext(),uri.toString(),Toast.LENGTH_SHORT).show();
    }
}
