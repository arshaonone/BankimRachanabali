package bankimrachanabali.probondho.com;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private AdRequest adRequest;

    private Context mContext;

    private ArrayList<String> titleText;

    private RecyclerView mRecyclerView;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-2606660907793468/6565095857");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mContext = MainActivity.this;

        titleText = new ArrayList<String>();

        titleText.add(Constants.BRANSONISM);
        titleText.add(Constants.NEW_YEARS_DAY);
        titleText.add(Constants.আকাশে_কত_তারা_আছে);
        titleText.add(Constants.আমার_মন);
        titleText.add(Constants.আশ্চর্য্য_সৌরোৎপাত);
        titleText.add(Constants.ইংরাজস্তোত্র);
        titleText.add(Constants.ইউটিলিটি_বা_উদর_দর্শন);
        titleText.add(Constants.একটি_গীত);
        titleText.add(Constants.একা_কে_গায়_ওই);
        titleText.add(Constants.কত_কাল_মনুষ্য);
        titleText.add(Constants.কমলাকান্তের_জোবানবন্দী);
        titleText.add(Constants.কমলাকান্তের_বিদায়);
        titleText.add(Constants.কি_লিখিব);
        titleText.add(Constants.কোন_স্পেশিয়ালের_পত্র);
        titleText.add(Constants.গগনপর্য্যটন);
        titleText.add(Constants.গর্দ্দভ);
        titleText.add(Constants.গ্রাম্য_কথা);
        titleText.add(Constants.চঞ্চল_জগৎ);
        titleText.add(Constants.চন্দ্রলোক);
        titleText.add(Constants.চন্দ্রালোকে);
        titleText.add(Constants.জৈবনিক);
        titleText.add(Constants.ঢেঁকি);
        titleText.add(Constants.দাম্পত্য_দণ্ডবিধির_আইন);
        titleText.add(Constants.ধূলা);
        titleText.add(Constants.পতঙ্গ);
        titleText.add(Constants.পরিমাণ_রহস্য);
        titleText.add(Constants.পলিটিক্‌স্);
        titleText.add(Constants.ফুলের_বিবাহ);
        titleText.add(Constants.বর্ষ_সমালোচন);
        titleText.add(Constants.বসন্ত_এবং_বিরহ);
        titleText.add(Constants.বসন্তের_কোকিল);
        titleText.add(Constants.বাঙ্গালা_সাহিত্যের_আদর);
        titleText.add(Constants.বাঙ্গালীর_মনুষ্যত্ব);
        titleText.add(Constants.বাবু);
        titleText.add(Constants.বিড়াল);
        titleText.add(Constants.বুড়া_বয়সের_কথা);
        titleText.add(Constants.ব্যাঘ্রাচার্য্য_বৃহল্লাঙ্গুল);
        titleText.add(Constants.বড়_বাজার);
        titleText.add(Constants.মনুষ্য_ফল);
        titleText.add(Constants.রামায়ণের_সমালোচন);
        titleText.add(Constants.সুবর্ণগোলক);
        titleText.add(Constants.স্ত্রীলোকের_রূপ);
        titleText.add(Constants.হনূমাদ্বাবুসংবাদ);



        mRecyclerView = (RecyclerView) findViewById(R.id.title_layout_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setHasFixedSize(true);


        TitleAdapter adapter = new TitleAdapter(mContext, titleText, new MyCustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Toast.makeText(mContext, "clicked - "+String.valueOf(titleText.get(position)), Toast.LENGTH_SHORT).show();

                Intent desIntent = new Intent(mContext,DescriptionActivity.class);

                desIntent.putExtra("titles",String.valueOf(titleText.get(position)));

                startActivity(desIntent);

            }
        });

        mRecyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Exit")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}


