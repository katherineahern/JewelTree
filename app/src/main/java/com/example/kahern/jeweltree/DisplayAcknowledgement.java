package com.example.kahern.jeweltree;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;


/**
 * Created by kahern on 1/22/15.
 */
public class DisplayAcknowledgement extends Activity{
    public MediaPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mPlayer = MediaPlayer.create(DisplayAcknowledgement.this, R.raw.acknowledgements);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acknowledgement);
        mPlayer.start();
    }

}
