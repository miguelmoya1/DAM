package es.isofocus.sounds;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play, stop, sound;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mediaPlayer = new MediaPlayer();

        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
        sound = (Button) findViewById(R.id.sound);

        play.setOnClickListener(e -> {});
        stop.setOnClickListener(e -> {});
        sound.setOnClickListener(e -> {});
    }
}
