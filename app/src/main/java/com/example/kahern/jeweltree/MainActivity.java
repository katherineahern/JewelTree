package com.example.kahern.jeweltree;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.content.Intent;
import android.text.util.Linkify;


public class MainActivity extends Activity {
    public Button play;
    public Button pause;
    public Button stop;
    public Button website;
    public MediaPlayer mPlayer;
    private double timeElapsed = 0, finalTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create(MainActivity.this, R.raw.jewel_tree_meditation);
        finalTime = mPlayer.getDuration();
        play = (Button)findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.start();
                timeElapsed = mPlayer.getCurrentPosition();
            }
         });

        mPlayer.setOnCompletionListener(new OnCompletionListener() {

            public void onCompletion(MediaPlayer mp) {
                //if mPlayer finished playing meditation
                displayAcknowledgement();
            }
        });

        pause = (Button)findViewById(R.id.pause_button);
        pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mPlayer.isPlaying()) {
                    mPlayer.pause();
                }
            }
        });

        stop = (Button)findViewById(R.id.stop_button);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mPlayer.isPlaying()) {
                    mPlayer.pause();
                    mPlayer.seekTo(0);
                }


            }



        });

        final TextView myClickableUrl = (TextView)findViewById(R.id.website);
        Linkify.addLinks(myClickableUrl, Linkify.WEB_URLS);




    }

    public void displayAcknowledgement() {
        Intent intent = new Intent(this, DisplayAcknowledgement.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        if (mPlayer != null) mPlayer.release();
    }
}
