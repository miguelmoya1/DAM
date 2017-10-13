package es.isofocus.casillas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonPlay;
    SeekBar seekX, seekY, seekPlots;
    CheckBox sound, vibration;
    RadioButton radioButtonC, radioButtonN;

    String typeButtonRadio = "colores";

    int x = 3, y = 3, p = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        seekX = (SeekBar)findViewById(R.id.seekX);
        seekY = (SeekBar)findViewById(R.id.seekY);
        seekPlots = (SeekBar)findViewById(R.id.seekPlots);
        radioButtonC = (RadioButton) findViewById(R.id.radioButtonColors);
        radioButtonN = (RadioButton) findViewById(R.id.radioButtonNumbers);

        sound = (CheckBox) findViewById(R.id.checkBoxSound);
        vibration = (CheckBox) findViewById(R.id.checkBoxVibration);

        seekX.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar bar){ }
            public void onProgressChanged(SeekBar bar, int paramInt, boolean paramBoolean) { }
            public void onStopTrackingTouch(SeekBar bar) { x = bar.getProgress(); }
        });
        seekY.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar bar){ }
            public void onProgressChanged(SeekBar bar, int paramInt, boolean paramBoolean) { }
            public void onStopTrackingTouch(SeekBar bar) { y = bar.getProgress(); }
        });
        seekPlots.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar bar){ }
            public void onProgressChanged(SeekBar bar, int paramInt, boolean paramBoolean) { }
            public void onStopTrackingTouch(SeekBar bar) { p = bar.getProgress(); }
        });

        buttonPlay.setOnClickListener(this);
        radioButtonC.setOnClickListener(this);
        radioButtonN.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonPlay) {
            Intent intent = new Intent(this, Game.class);
            Bundle bundle = new Bundle();

            bundle.putInt("seekX", x);
            bundle.putInt("seekY", y);
            bundle.putInt("seekPlots", p);
            bundle.putString("type", typeButtonRadio);
            bundle.putBoolean("sound", sound.isChecked());
            bundle.putBoolean("vibration", vibration.isChecked() );

            intent.putExtra("data", bundle);
            startActivity(intent);
        } else if (v.getId() == R.id.radioButtonColors) {
            typeButtonRadio = "colores";
        } else if(v.getId() == R.id.radioButtonNumbers) {
            typeButtonRadio = "numeros";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
