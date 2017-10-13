package es.isofocus.casillas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getBundleExtra("data");

        textView = (TextView) findViewById(R.id.textView);

        String text = "Número de elementos en la X: " + bundle.get("seekX") +
                "\n Número de elementos en la Y: " + bundle.getInt("seekY") +
                "\n Número de plops: " + bundle.get("seekPlots") +
                "\n Typo: " + bundle.get("type") +
                "\n Sonido activo: " + bundle.get("sound") +
                "\n Vibración activada: " + bundle.get("vibration");

        textView.setText(text);
    }

}
