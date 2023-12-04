package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;

import com.brightcove.player.analytics.Analytics;
import com.brightcove.player.model.DeliveryType;
import com.brightcove.player.model.Video;
import com.brightcove.player.view.BrightcoveExoPlayerVideoView;
import com.brightcove.player.view.BrightcovePlayer;

import java.net.URISyntaxException;

public class MainActivity extends BrightcovePlayer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        // Create the video view
        brightcoveVideoView = (BrightcoveExoPlayerVideoView) findViewById(R.id.brightcove_video_view);

        super.onCreate(savedInstanceState);

        // Optional: For Brightcove Player customers to register their apps
        Analytics analytics = brightcoveVideoView.getAnalytics();
        analytics.setAccount("your account Id");

        // Define a video from a remote server
        Video video = Video.createVideo("https://sdks.support.brightcove.com/assets/videos/hls/greatblueheron/greatblueheron.m3u8",
                DeliveryType.HLS);

        // Load a remote poster image
        try {
            java.net.URI myposterImage = new java.net.URI("https://sdks.support.brightcove.com/assets/images/general/Great-Blue-Heron.png");
            video.getProperties().put(Video.Fields.STILL_IMAGE_URI, myposterImage);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        // Add video to the view
        brightcoveVideoView.add(video);
        // Start video playback
        brightcoveVideoView.start();

    }
}