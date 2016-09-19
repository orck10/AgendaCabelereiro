package com.example.aluno.agendacabelereiro;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Tela2 extends AppCompatActivity implements View.OnClickListener {

    ListaDeAgendamento modelos =  new ListaDeAgendamento();

    private String nomeDoPrestador = new String();

    private Button bm;
    private Button bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        Intent intent = getIntent();
        nomeDoPrestador = intent.getStringExtra("nomeDoPrestador");

        modelos.getAgendamento();

        bm = (Button) findViewById(R.id.marcados);
        bm.setOnClickListener(this);
        bv = (Button) findViewById(R.id.vagos);
        bv.setOnClickListener(this);

        final List<String> datasMarcadas = modelos.retornaDiasAgendados(nomeDoPrestador);

        ArrayAdapter<String> adapterDias = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datasMarcadas);

        final Spinner spinnerDatas = (Spinner) findViewById(R.id.datas);

        spinnerDatas.setAdapter(adapterDias);

        spinnerDatas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                TextView areaDeResultado = (TextView) findViewById(R.id.datas_marcadas);//mostra o dia selecionado

                String dataSelecionada = String.valueOf(spinnerDatas.getSelectedItem());

                areaDeResultado.setText(dataSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                //Se nada for selecionado não faz nada
            }

        });
    }

    public void onClick(View view){
        Spinner spinnerDatas = (Spinner) findViewById(R.id.datas);
        String  dataSelecionada = String.valueOf(spinnerDatas.getSelectedItem());

        Button button = (Button) view;

        if(button.getText().equals("Horarios Marcados")){
            Intent myIntent = new Intent(this, Tela3.class);
            myIntent.putExtra("nomeDoPrestador", nomeDoPrestador); //Passa o nome do prestador como referencia
            myIntent.putExtra("dataMarcada", dataSelecionada);//Passa a data selecionada
            myIntent.putExtra("tipo", "marcado");
            this.startActivity(myIntent);
        }
        else if(button.getText().equals("Horarios Vagos")){
            Intent myIntent = new Intent(this, Tela3.class);
            myIntent.putExtra("nomeDoPrestador", nomeDoPrestador); //Passa o nome do prestador como referencia
            myIntent.putExtra("dataMarcada", dataSelecionada);//Passa a data selecionada
            myIntent.putExtra("tipo", "vago");
            this.startActivity(myIntent);
        }
    }
}
