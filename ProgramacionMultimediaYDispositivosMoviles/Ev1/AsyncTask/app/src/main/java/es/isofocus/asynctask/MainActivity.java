package es.isofocus.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button, button1, button2;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progressBar);

        button.setOnClickListener(e -> {
            for (int i = 0; i < 10; i++) wait1sec();
            Toast.makeText(getApplicationContext(), "Boton terminado", Toast.LENGTH_LONG).show();
        });
        button1.setOnClickListener(e ->  new Thread(() -> {
            for (int i = 0; i < 10; i++) wait1sec();
            runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Boton 1 terminado", Toast.LENGTH_LONG).show());
        }).start());
        button2.setOnClickListener(e -> {
            EjemploAsyncTask asyn = new EjemploAsyncTask();
            asyn.execute();
            Toast.makeText(getApplicationContext(), "Boton 2 terminado", Toast.LENGTH_LONG);

        });
    }

    private void wait1sec() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e1) {}
    }

    public class EjemploAsyncTask extends AsyncTask<Void, Integer, Void> {

        @Override
        protected void onPreExecute() {
            progressBar.setMax(1000);
            progressBar.setProgress(0);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 10000; i++) {
                wait1sec();
                publishProgress((i + 1));
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onCancelled(Void aVoid) {
            super.onCancelled(aVoid);
        }
    }
}
