package es.isofocus.sounds;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        play = findViewById(R.id.play);
        stop = findViewById(R.id.stop);
        sound = findViewById(R.id.sound);

        play.setOnClickListener(e -> play());
        stop.setOnClickListener(e -> stop());
        sound.setOnClickListener(e -> {});
    }

    private void play() {
        mediaPlayer = MediaPlayer.create(this, R.raw.a);
        mediaPlayer.start();
    }

    private void stop() {
        mediaPlayer.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        play();
    }
}
