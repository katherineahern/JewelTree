package com.example.kahern.jeweltree;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends Activity {
    public Button play;
    public TextView test_button;
    public MediaPlayer mPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_button = (TextView)findViewById(R.id.test_button);
        play = (Button)findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test_button.setText("pushed button");
                mPlayer = MediaPlayer.create(MainActivity.this, R.raw.jewel_tree_meditation);
                mPlayer.start();
                Log.v("File context: ", Environment.getExternalStorageDirectory().getPath());
                /*Uri introURI;
                introURI = Uri.parse("android.resource://com.example.kahern.jeweltree/" + R.raw.JewelTreeMeditation);
                MediaPlayer mediaPlayer = new MediaPlayer();

               MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Music/intro.mp3"));
                MediaPlayer.start();*/
            }
        });
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
}
