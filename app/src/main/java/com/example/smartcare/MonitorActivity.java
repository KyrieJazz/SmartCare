package com.example.smartcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dueeeke.videoplayer.player.VideoView;
import com.dueeeke.videocontroller.StandardVideoController;

public class MonitorActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        //本地视频播放测试
        videoView = (VideoView) findViewById(R.id.player);
        videoView.setUrl("rtmp://58.200.131.2:1935/livetv/hunantv");
        StandardVideoController controller = new StandardVideoController(this);
        controller.addDefaultControlComponent("RTMP测试——湖南电视台直播", false);
        //设置控制器
        videoView.setVideoController(controller);
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        videoView.release();
    }

    @Override
    public void onBackPressed() {
        if(!videoView.onBackPressed()) {
            super.onBackPressed();
        }
    }
}