package com.ranag.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Objects;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;


public class WebView extends AppCompatActivity {
    android.webkit.WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ImageView back = findViewById(R.id.backweb);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView.super.onBackPressed();
            }
        });

        Intent intent = getIntent();
        String linkid = intent.getStringExtra("link");

        YouTubePlayerView youTubePlayerView = findViewById(R.id.video);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {

            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {


                String id = linkid;
                youTubePlayer.loadVideo(id, 0);
//                youTubePlayerView.addFullscreenListener(new FullscreenListener() {
//                    @Override
//                    public void onEnterFullscreen(@NonNull View view, @NonNull Function0<Unit> function0) {
//                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//                    }
//
//                    @Override
//                    public void onExitFullscreen() {
//                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//
//                    }
//                });

//                youTubePlayer.toggleFullscreen();

            }
        });
    }
}