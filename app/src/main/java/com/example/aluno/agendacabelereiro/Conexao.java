package com.example.aluno.agendacabelereiro;

/**
 * Created by Aluno on 25/08/2016.
 */

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conexao {

    private final String USER_AGENT = "Mozilla/5.0";

    public List<Agendamento> sendGetAgendamento() throws Exception{
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String url = "https://api.myjson.com/bins/476ag";

        URL site = new URL(url);
        HttpURLConnection conect = (HttpURLConnection) site.openConnection();

        //Metodo Opicional
        conect.setRequestMethod("GET");

        //add cabeçãlho de leitura
        conect.setRequestProperty("User-Agent", USER_AGENT);

        int codigo_de_resposta = conect.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + codigo_de_resposta);



        //cria bufer de conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(conect.getInputStream()));
        String inputLine;
        StringBuffer resposta = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            resposta.append(inputLine);
        }
        in.close();

        System.out.println(resposta.toString());

        List<Agendamento> encontrados = procurarTodosItensAgendamento(new JSONArray(resposta.toString()));

        return encontrados;
    }

    public List<Usuario> sendGetUsuario() throws Exception{
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String url = "https://api.myjson.com/bins/124uq";

        URL site = new URL(url);
        HttpURLConnection conect = (HttpURLConnection) site.openConnection();

        //Metodo Opicional
        conect.setRequestMethod("GET");

        //add cabeçãlho de leitura
        conect.setRequestProperty("User-Agent", USER_AGENT);

        int codigo_de_resposta = conect.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + codigo_de_resposta);



        //cria bufer de conexão
        BufferedReader in = new BufferedReader(new InputStreamReader(conect.getInputStream()));
        String inputLine;
        StringBuffer resposta = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            resposta.append(inputLine);
        }
        in.close();

        System.out.println(resposta.toString());

        List<Usuario> encontrados = procurarTodosItensUsuario(new JSONArray(resposta.toString()));

        return encontrados;
    }

    public List<Agendamento> procurarTodosItensAgendamento(JSONArray resposta){
        List<Agendamento> encontrados = new LinkedList<Agendamento>();

        try{
            for(int i = 0; i < resposta.length(); i++){
                JSONObject obj = resposta.getJSONObject(i);
                encontrados.add(new Agendamento(obj.getString("nome"), obj.getString("dia"), obj.getString("hora"), obj.getString("servidor")));
            }
        } catch (JSONException e) {

        }

        return encontrados;

    }

    public List<Usuario> procurarTodosItensUsuario(JSONArray resposta){
        List<Usuario> encontrados = new LinkedList<Usuario>();

        try{
            for(int i = 0; i < resposta.length(); i++){
                JSONObject obj = resposta.getJSONObject(i);
                encontrados.add(new Usuario(obj.getString("cpf"), obj.getString("nome"), obj.getString("celular"), obj.getString("senha"), obj.getString("tipo")));
            }
        } catch (JSONException e) {

        }

        return encontrados;

    }

}
