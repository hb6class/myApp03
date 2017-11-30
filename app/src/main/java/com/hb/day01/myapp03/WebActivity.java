package com.hb.day01.myapp03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class WebActivity extends AppCompatActivity {
    WebView webView;
    EditText urlTxt;
    Button button;
    ProgressBar progressBar2;
    ProgressBar progressBar4;

    public void onClick(View v){
        String url=urlTxt.getText().toString();
        if(url.indexOf("http://")==-1){
            url="http://"+url;
        }
        webView.loadUrl(url);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        progressBar2= (ProgressBar) findViewById(R.id.progressBar2);
        progressBar4= (ProgressBar) findViewById(R.id.progressBar4);
        urlTxt= (EditText) findViewById(R.id.urlTxt);
        button= (Button) findViewById(R.id.button);
        webView= (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        progressBar2.setVisibility(View.GONE);
        progressBar4.setVisibility(View.GONE);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar2.setProgress(newProgress);
                progressBar4.setProgress(newProgress);
                if(newProgress==100){
                    progressBar2.setVisibility(View.GONE);
                    progressBar4.setVisibility(View.GONE);
                }else{
                    progressBar2.setVisibility(View.VISIBLE);
                    progressBar4.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}







