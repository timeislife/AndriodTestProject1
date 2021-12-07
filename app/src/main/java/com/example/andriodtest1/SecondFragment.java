package com.example.andriodtest1;

import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.andriodtest1.databinding.FragmentSecondBinding;

import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.app.ProgressDialog;
import android.app.Activity;
import 	android.util.Log;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private ProgressDialog progDialog;
    private  WebView myWebView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        //ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_second, null);
        //View root=inflater.inflate(R.layout.fragment_second, container, false);

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        ConstraintLayout root = binding.getRoot();

        Log.i("andriodtest1", "Start using webview");

        myWebView = (WebView) root.findViewById(R.id.webview1);
        /*
        WebSettings mWebSettings = myWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setDomStorageEnabled(true);
        WebViewClient mWebViewClient = new WebViewClient();
        myWebView.setWebViewClient(mWebViewClient);
        myWebView.loadUrl("https://www.baidu.com");

        Log.i("andriodtest1", "Finish using webview");

        */
        /*
        progDialog = ProgressDialog.show(getActivity(), "Loading","Please wait...", true);
        progDialog.setCancelable(false);
        */
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.setWebViewClient(new WebViewClient());
        //myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        //myWebView.getSettings().setLoadWithOverviewMode(true);
        //myWebView.getSettings().setUseWideViewPort(true);
        //myWebView.getSettings().setAppCacheEnabled(true);
        //myWebView.getSettings().setBlockNetworkImage(false);
        //myWebView.getSettings().setBlockNetworkLoads(false);
        //myWebView.getSettings().setDomStorageEnabled(true);
        //myWebView.getSettings().setLoadsImagesAutomatically(true);

        myWebView.loadUrl("https://www.hellopp.cn/read/page/5e7aff4d775e75e01488325a");

        //myWebView.clearView();
        //myWebView.measure(100, 100);
        //myWebView.getSettings().setUseWideViewPort(true);
/*
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            myWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
*/
        /*
        myWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
                //super.onReceivedSslError(view, handler, error);
                Log.d("andriodtest1", "onReceivedSslError: "); //如果是证书问题，会打印出此条log到console
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDialog.show();
                Log.i("andriodtest1", "shouldOverrideUrlLoading");
                //return false;
                //view.loadUrl(url);
                view.loadUrl("https://www.hellopp.cn/read/page/5e7aff4d775e75e01488325a");
                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDialog.dismiss();
                Log.i("andriodtest1", "onPageFinished");
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e("andriodtest1", "onReceivedError: " + description);
            }

        });
*/
        //myWebView.loadUrl("https://www.hellopp.cn/read/page/5e7aff4d775e75e01488325a");

        /*
        String unencodedHtml =
                "<html><body>'%23' is the percent code for ‘#‘ </body></html>";
        String encodedHtml = Base64.encodeToString(unencodedHtml.getBytes(),
                Base64.NO_PADDING);
        myWebView.loadData(encodedHtml, "text/html", "base64");

         */


        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}