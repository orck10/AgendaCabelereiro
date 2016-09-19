package com.example.aluno.agendacabelereiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ListaDeAgendamento modelos =  new ListaDeAgendamento();

    private Button botaoVerificaData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modelos.getAgendamento();

        botaoVerificaData = (Button) findViewById(R.id.verificar_datas);
        botaoVerificaData.setOnClickListener(this);

        final List<String> servidores = modelos.retornaTodosServidores();

        ArrayAdapter<String> adapterServidores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, servidores);

        final Spinner spinnerServidores = (Spinner) findViewById(R.id.servidor);

        spinnerServidores.setAdapter(adapterServidores);

        spinnerServidores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
                TextView areaDeResultado = (TextView) findViewById(R.id.nomeServidor);//mostra o nome do servidor selecionado

                String servidorSelecionado = String.valueOf(spinnerServidores.getSelectedItem());

                areaDeResultado.setText(servidorSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView){
                //Se nada for selecionado não faz nada
            }

        });

    }

    public void onClick(View view){
        Spinner spinnerServidor = (Spinner) findViewById(R.id.servidor);
        String servidorSelecionado = String.valueOf(spinnerServidor.getSelectedItem());

        if(servidorSelecionado != null){
            Intent myIntent = new Intent(MainActivity.this, Tela2.class);
            myIntent.putExtra("nomeDoPrestador", servidorSelecionado); //Passa o nome do prestador como referencia
            MainActivity.this.startActivity(myIntent);
        }
        else{
            AlertDialog.Builder dlg= new AlertDialog.Builder(this);
            dlg.setMessage("Não há ninguem selecionado");
            dlg.setNeutralButton("OK", null);
            dlg.show();
        }
    }
}
//https://api.myjson.com/bins/2hh9r
//https://api.myjson.com/bins/1we9w
//29/08/2016
//https://api.myjson.com/bins/476ag

//mjson do usuario
//https://api.myjson.com/bins/2vpyq