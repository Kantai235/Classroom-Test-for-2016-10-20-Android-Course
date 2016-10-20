package com.example.kantai.smallexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class dockerView extends AppCompatActivity {

    // https://www.sitepoint.com/using-the-youtube-api-to-embed-video-in-an-android-app/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docker_view);

        VideoView videoView = (VideoView) this.findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        //本次用project下的目錄作為路徑來示範
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        videoView.requestFocus();
        videoView.start();
    }

    public void viewBackClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
