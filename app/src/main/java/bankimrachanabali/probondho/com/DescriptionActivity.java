package bankimrachanabali.probondho.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class DescriptionActivity extends AppCompatActivity {
    private AdRequest adRequest;
    private InterstitialAd interstitialAd;
    private AdView mAdView;


    private WebView simpleWebView;

    private static final String TAG = "DescriptionActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);




        MobileAds.initialize(this, "ca-app-pub-2606660907793468/5203256189");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        adRequest = new AdRequest.Builder().build();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-2606660907793468/1616021507");
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                dispAd();

            }
        });

        //Back Button Added
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        simpleWebView = (WebView) findViewById(R.id.desWebView);
        simpleWebView.setWebViewClient(new WebViewClient());


        Bundle extras = getIntent().getExtras();

        if (!extras.equals(null)) {

            String data = extras.getString("titles");

            Log.e(TAG, "onCreate: the data is " + data);


            String url = "file:///android_asset/" + data + ".html";

            simpleWebView.loadUrl(url);

        }

        WebSettings webSettings = simpleWebView.getSettings();

        webSettings.setBuiltInZoomControls(true);

        webSettings.setDisplayZoomControls(false);

        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (simpleWebView.canGoBack()) {

            simpleWebView.goBack();
        } else {

            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void dispAd() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }
}