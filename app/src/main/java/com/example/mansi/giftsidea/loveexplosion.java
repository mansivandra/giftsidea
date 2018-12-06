package com.example.mansi.giftsidea;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.internal.v;

import java.util.Timer;
import java.util.TimerTask;


public class loveexplosion extends YouTubeBaseActivity {
    TextView t1, t2, t3, t4, t5;
    ViewPager viewPager;
    LinearLayout sliderDotspanel;

    private int dotscount;
    private ImageView[] dots;
    YouTubePlayerView youTubePlayerView;
    Button button1, button2;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    Dialog myDialog;
    PopupWindow mPopupWindow;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loveexplosion);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        relativeLayout = (RelativeLayout) findViewById(R.id.rel);
        button1 = (Button) findViewById(R.id.btn1);
        button2 = (Button) findViewById(R.id.btn2);

        viewpageadapterlove Viewpageadapterlove = new viewpageadapterlove(loveexplosion.this);
        viewPager.setAdapter(Viewpageadapterlove);
        dotscount = Viewpageadapterlove.getCount();
        dots = new ImageView[dotscount];

        for (
                int i = 0;
                i < dotscount; i++)

        {

            dots[i] = new ImageView(loveexplosion.this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactivity_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);


        }

        dots[0].

                setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.activity_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()

        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactivity_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.activity_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loveexplosion.this, buynow.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) loveexplosion.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.ustompopup, null);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=rgWpOQ3wmvk")));
                Log.i("video", "video palying....");

//                youTubePlayerView = (YouTubePlayerView) customView.findViewById(R.id.youtube);
//                onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//                    @Override
//                    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                        youTubePlayer.loadVideo("rgWpOQ3wmvk");
//                    }
//
//                    @Override
//                    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
            }
        });


//            mPopupWindow = new PopupWindow(
//                       customView,
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                       ViewGroup.LayoutParams.WRAP_CONTENT
//            );
//        youTubePlayerView.initialize(playerconfig.API_KEY, onInitializedListener);
  //      mPopupWindow.showAtLocation(relativeLayout, Gravity.CENTER, 0, 0);


        //              Button closeButton = (Button) customView.findViewById(R.id.close);
//
//                // Set a click listener for the popup window close button
//                closeButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        // Dismiss the popup window
//                        mPopupWindow.dismiss();

        //                   }

        //               });


        t1 = (TextView) findViewById(R.id.tt);

        t2 = (TextView) findViewById(R.id.t1);

        t3 = (TextView) findViewById(R.id.t2);

        t4 = (TextView) findViewById(R.id.t3);

        t5 = (TextView) findViewById(R.id.t4);


    }
}
