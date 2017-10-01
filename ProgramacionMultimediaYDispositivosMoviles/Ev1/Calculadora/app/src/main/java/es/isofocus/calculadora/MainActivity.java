package es.isofocus.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<Button> buttons;
    TextView display;
    int total;
    String lastMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = 0;

        buttons = new LinkedList<>();

        buttons.add((Button) findViewById(R.id.b1));
        buttons.add((Button) findViewById(R.id.b2));
        buttons.add((Button) findViewById(R.id.b3));

        buttons.add((Button) findViewById(R.id.b4));
        buttons.add((Button) findViewById(R.id.b5));
        buttons.add((Button) findViewById(R.id.b6));

        buttons.add((Button) findViewById(R.id.b7));
        buttons.add((Button) findViewById(R.id.b8));
        buttons.add((Button) findViewById(R.id.b9));

        buttons.add((Button) findViewById(R.id.bmas));
        buttons.add((Button) findViewById(R.id.bmenos));

        display = (TextView) findViewById(R.id.textView);

        buttons.forEach(button -> button.setOnClickListener(this));
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.b1:
                display.append("1");
            break;
            case R.id.b2:
                display.append("2");
                break;
            case R.id.b3:
                display.append("3");
                break;
            case R.id.b4:
                display.append("4");
                break;
            case R.id.b5:
                display.append("5");
                break;
            case R.id.b6:
                display.append("6");
                break;
            case R.id.b7:
                display.append("7");
                break;
            case R.id.b8:
                display.append("8");
                break;
            case R.id.b9:
                display.append("9");
                break;
            case R.id.bmas:
                total += Integer.parseInt(display.getText().toString());
                display.setText("");
                lastMethod = "+";
                break;
            case R.id.bmenos:
                total -= Integer.parseInt(display.getText().toString());
                display.setText("");
                lastMethod = "-";
                break;
            case R.id.benter:
                switch (lastMethod) {
                    case "+":
                        total += Integer.parseInt(display.getText().toString());
                        display.setText(total + "");
                        break;
                    case "-":
                        total -= Integer.parseInt(display.getText().toString());
                        display.setText(total + "");
                        break;
                }
                display.append("1");
                break;

        }
    }
}
