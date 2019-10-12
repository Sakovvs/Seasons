package com.svs.task2seasons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    Button btnCalculate;
    TextView tvSpring, tvSummer, tvAutumn, tvWinter;
    EditText etYear;
    EditText etHour;
    int mYear;
    double m1, m2, m3, m4, ve, ss, ae, ws, ds;
    Jdays cjdSpring = new Jdays();
    Jdays cjdSummer = new Jdays();
    Jdays cjdAutumn = new Jdays();
    Jdays cjdWinter = new Jdays();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btnCalculate);
        tvSpring = findViewById(R.id.tvSpring);
        tvSummer = findViewById(R.id.tvSummer);
        tvAutumn = findViewById(R.id.tvAutumn);
        tvWinter = findViewById(R.id.tvWinter);
        etYear = findViewById(R.id.etYear);
        etHour = findViewById(R.id.etHour);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etYear.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Введите год", Toast.LENGTH_SHORT);
                } else {
                    calculate();
                }
            }
        });
    }

    private void calculate() {

       ds = (parseDouble(etHour.getText().toString()))/24  ;

        mYear = (Integer.parseInt(etYear.getText().toString()));
        m1 = (mYear - 2000.) / 1000.;
        m2 = m1 * m1;
        m3 = m2 * m1;
        m4 = m3 * m1;
        ve = 2451623.80984 + 365242.37404 * m1 + 0.05169 * m2 - 0.00411 * m3 - 0.00057 * m4 + ds; // весна
        ss = 2451716.56767 + 365241.62603 * m1 + 0.00325 * m2 + 0.00888 * m3 - 0.00030 * m4+ ds; // лето
        ae = 2451810.21715 + 365242.01767 * m1 - 0.11575 * m2 + 0.00337 * m3 + 0.00078 * m4+ ds; // осень
        ws = 2451900.05952 + 365242.74049 * m1 - 0.06223 * m2 - 0.00823 * m3 + 0.00032 * m4+ ds; // зима*/


        cjdSpring.set(ve);
        cjdSummer.set(ss);
        cjdAutumn.set(ae);
        cjdWinter.set(ws);

        tvSpring.setText("Весенней равноденствие\n" + cjdSpring.format(Jdays.DMYHM));
        tvSummer.setText("Летнее солнцестояние\n" + cjdSummer.format(Jdays.DMYHM));
        tvAutumn.setText("Осеннее равноденствие\n" + cjdAutumn.format(Jdays.DMYHM));
        tvWinter.setText("Зимнее солнцестояние\n" + cjdWinter.format(Jdays.DMYHM));
    }
}
