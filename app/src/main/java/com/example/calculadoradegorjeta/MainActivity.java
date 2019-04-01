package com.example.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView gorjeta;
    private TextView total;
    private TextView porcentagem;
    private EditText valor;
    private SeekBar seekBar;
    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gorjeta = findViewById(R.id.gorjeta);
        valor = findViewById(R.id.valor);
        porcentagem = findViewById(R.id.porcentagem);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(15);
        seekBar.setProgress(0);
        total = findViewById(R.id.total);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progresso = seekBar.getProgress();
                porcentagem.setText(progresso + "%");
                calcularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void calcularGorjeta(){
        Double val = Double.parseDouble(valor.getText().toString());

        double resultado = val * progresso / 100;
        gorjeta.setText("R$" + resultado);
        total.setText("R$" + (resultado + val));
    }

}
