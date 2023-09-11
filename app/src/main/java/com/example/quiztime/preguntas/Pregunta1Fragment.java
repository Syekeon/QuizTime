package com.example.quiztime.preguntas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.quiztime.GestionPuntuacion;
import com.example.quiztime.QuizActivity;
import com.example.quiztime.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pregunta1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pregunta1Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GestionPuntuacion gestionPuntuacion;

    public Pregunta1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pregunta1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Pregunta1Fragment newInstance(String param1, String param2) {
        Pregunta1Fragment fragment = new Pregunta1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pregunta1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button opcion1 = view.findViewById(R.id.button_prg1_opcion1);
        Button opcion2 = view.findViewById(R.id.button_prg1_opcion2);
        Button opcion3 = view.findViewById(R.id.button_prg1_opcion3);
        Button opcion4 = view.findViewById(R.id.button_prg1_opcion4);
        Button volverEmpezar = view.findViewById(R.id.button_volverempezar);
        Button siguiente = view.findViewById(R.id.button_siguiente);

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarRespuesta(opcion1, opcion1, siguiente);
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                opcion3.setEnabled(false);
                opcion4.setEnabled(false);
            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarRespuesta(opcion2, opcion1, siguiente);
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                opcion3.setEnabled(false);
                opcion4.setEnabled(false);
            }
        });

        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarRespuesta(opcion3, opcion1, siguiente);
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                opcion3.setEnabled(false);
                opcion4.setEnabled(false);
            }
        });

        opcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprobarRespuesta(opcion4, opcion1, siguiente);
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                opcion3.setEnabled(false);
                opcion4.setEnabled(false);
            }
        });

        volverEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gestionPuntuacion.volverEmpezar(view);
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.pregunta2Fragment);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof GestionPuntuacion) {
            gestionPuntuacion = (GestionPuntuacion) context;
        }
    }

    private void comprobarRespuesta(Button opcionSeleccionada, Button opcionCorrecta, Button siguiente) {
        if (opcionSeleccionada.getId() == opcionCorrecta.getId()) {
            gestionPuntuacion.acierto();
            opcionSeleccionada.setBackgroundResource(R.drawable.btn_acierto);
            Toast.makeText(getContext(), "¡Respuesta correcta! ¡Has ganado 3 puntos!", Toast.LENGTH_SHORT).show();
        } else {
            gestionPuntuacion.fallo();
            opcionSeleccionada.setBackgroundResource(R.drawable.btn_fallo);
            opcionCorrecta.setBackgroundResource(R.drawable.btn_acierto);
            Toast.makeText(getContext(), "¡Respuesta incorrecta! ¡Has perdido 2 puntos!", Toast.LENGTH_SHORT).show();
        }

        siguiente.setEnabled(true);
        siguiente.setBackgroundResource(R.drawable.btn_general);
    }
}