package com.example.quiztime;

import android.view.View;

public interface GestionPuntuacion {
    void verResultados(View view);
    void volverEmpezar(View view);
    void acierto();
    void fallo();
}
