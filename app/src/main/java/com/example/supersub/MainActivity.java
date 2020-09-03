package com.example.supersub;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supersub.model.ResponseData;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    WebView videoView;
    private MyWebChromeClient mWebChromeClient = null;
    ImageView img;
    TextView toolbarName, txtDis, txtCaption, txtTitle, txtDisc;
    private LinearLayout mContentView;
    private FrameLayout mCustomViewContainer;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    private View mCustomView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = (WebView) findViewById(R.id.webView);
        img = (ImageView) findViewById(R.id.img);
        toolbarName = (TextView) findViewById(R.id.toolbarName);
        txtCaption = (TextView) findViewById(R.id.txtCaption);
        txtDis = (TextView) findViewById(R.id.txtDis);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtDisc = (TextView) findViewById(R.id.txtDisc);

        getRetrofitObject();

    }


    public void getRetrofitObject() {

        ApiInterface apiService =
                ClientAPI.getClient().create(ApiInterface.class);

        Call<ResponseData> call = apiService.getJsonData();
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.e("MainActivity ", "Success response.");

                if (response != null) {

                    toolbarName.setText(response.body().getCategory() + "");
                    txtTitle.setText(response.body().getTitle() + "");
                    txtDisc.setText(response.body().getDescription() + "");

                    Uri video =Uri.parse(response.body().getVideo().getUrl()+"/media.mp4");
                    Log.e("MainActivity ", "video "+video);

                    mWebChromeClient = new MyWebChromeClient();
                    videoView.setWebChromeClient(mWebChromeClient);
                    videoView.setWebViewClient(new WebViewClient(){
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            return false;
                        }
                    });
                    WebSettings webSettings = videoView.getSettings();
                    webSettings.setJavaScriptEnabled(true);
                    videoView.loadUrl(String.valueOf(video));


                    if (response.body().getIllustrations() != null) {

                        if (response.body().getIllustrations().get(0).getImageUrl() != null) {
                            ////////////////////
                            //load Picasso
                            Picasso.with(MainActivity.this)
                                    .load(response.body().getIllustrations().get(0).getImageUrl())
                                    .into(img);
                        }

                        txtCaption.setText(response.body().getIllustrations().get(0).getCaption() + "");
                        txtDis.setText(response.body().getIllustrations().get(0).getDescription() + "");

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
                Log.e("MainActivity ", "fail response.");
            }
        });

    }

    public class MyWebChromeClient extends WebChromeClient {

        FrameLayout.LayoutParams LayoutParameters = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mContentView = (LinearLayout) findViewById(R.id.activity_main);
            mContentView.setVisibility(View.GONE);
            mCustomViewContainer = new FrameLayout(MainActivity.this);
            mCustomViewContainer.setLayoutParams(LayoutParameters);
            mCustomViewContainer.setBackgroundResource(android.R.color.black);
            view.setLayoutParams(LayoutParameters);
            mCustomViewContainer.addView(view);
            mCustomView = view;
            mCustomViewCallback = callback;
            mCustomViewContainer.setVisibility(View.VISIBLE);
            setContentView(mCustomViewContainer);
        }

        @Override
        public void onHideCustomView() {
            if (mCustomView == null) {
                return;
            } else {
                // Hide the custom view.
                mCustomView.setVisibility(View.GONE);
                // Remove the custom view from its container.
                mCustomViewContainer.removeView(mCustomView);
                mCustomView = null;
                mCustomViewContainer.setVisibility(View.GONE);
                mCustomViewCallback.onCustomViewHidden();
                // Show the content view.
                mContentView.setVisibility(View.VISIBLE);
                setContentView(mContentView);
            }
        }
    }
    @Override
    public void onBackPressed() {
        if (mCustomViewContainer != null)
            mWebChromeClient.onHideCustomView();
        else if (videoView.canGoBack())
            videoView.goBack();
        else
            super.onBackPressed();
    }
}


