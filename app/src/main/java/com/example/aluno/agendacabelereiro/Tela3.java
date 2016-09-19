package com.example.aluno.agendacabelereiro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tela3 extends AppCompatActivity {

    ListaDeAgendamento modelos =  new ListaDeAgendamento();

    private String nomeDoPrestador = new String();
    private String dataSelecionada = new String();
    private String tipo = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        modelos.getAgendamento();
        Intent intent = getIntent();
        nomeDoPrestador = intent.getStringExtra("nomeDoPrestador");
        dataSelecionada = intent.getStringExtra("dataMarcada");
        tipo = intent.getStringExtra("tipo");

        TextView areaDeResultado = (TextView) findViewById(R.id.horarioSelecionado);
        areaDeResultado.setText(tipo);
    }
}
