package com.example.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        Bundle recibeDatos = getIntent().getExtras();
        int[] datos = recibeDatos.getIntArray("keyDatos");

        TextView txtPuntuacion = (TextView) findViewById(R.id.text_puntuacion);
        TextView txtPreguntas = (TextView) findViewById(R.id.text_preguntas);
        TextView txtAciertos = (TextView) findViewById(R.id.text_aciertos);
        TextView txtFallos = (TextView) findViewById(R.id.text_fallos);

        txtPuntuacion.setText("" + datos[0]);
        txtPreguntas.setText("" + datos[1]);
        txtAciertos.setText("" + datos[2]);
        txtFallos.setText("" + datos[3]);
    }

    public void volverMenu(View v) {
        Intent volverMenu = new Intent(this, MainActivity.class);
        startActivity(volverMenu);
    }

    public void volverQuiz(View v) {
        Intent volverQuiz = new Intent(this, QuizActivity.class);
        startActivity(volverQuiz);
    }
}