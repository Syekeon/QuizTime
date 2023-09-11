package com.example.quiztime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class QuizActivity extends AppCompatActivity implements GestionPuntuacion {
    private int puntuacion = 0;
    private int preguntas = 0;
    private int aciertos = 0;
    private int fallos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void verResultados(View view) {
        int[] datos = new int[] {puntuacion, preguntas, aciertos, fallos};
        Bundle enviaDatos = new Bundle();
        enviaDatos.putIntArray("keyDatos", datos);

        Intent resultados = new Intent(this, ResultadoActivity.class);
        resultados.putExtras(enviaDatos);
        startActivity(resultados);
    }

    @Override
    public void volverEmpezar(View v) {
        Intent quiz = new Intent(this, QuizActivity.class);
        startActivity(quiz);
    }

    @Override
    public void acierto() {
        preguntas++;
        aciertos++;
        puntuacion += 3;
    }

    @Override
    public void fallo() {
        preguntas++;
        fallos++;
        puntuacion -= 2;
    }
}