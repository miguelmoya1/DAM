package es.isofocus.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    Sensor acelerometro, lum, other;
    TextView text, text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        lum = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        text = (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);

        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this, lum, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent)  {
        text.setText("");
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x, y, z;

            x = sensorEvent.values[0];
            y = sensorEvent.values[1];
            z = sensorEvent.values[2];

            text.append("X: " + x);
            text.append("\nY: " + y);
            text.append("\nZ: " + z);
        }
        else if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            text2.setText("");
            text2.append("X: " + sensorEvent.values[0]);
        } else
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
