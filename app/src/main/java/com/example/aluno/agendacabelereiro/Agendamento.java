package com.example.aluno.agendacabelereiro;

import java.util.List;

/**
 * Created by Aluno on 25/08/2016.
 */
public class Agendamento {
    private String cliente = new String();
    private String data = new String();
    private String hora = new String();
    private String servidor = new String();//servidor é um prestador de serviço, não o servidor de internet

    public Agendamento(String cliente, String data, String hora, String servidor){
        this.cliente = cliente;
        this.data = data;
        this.hora = hora;
        this.servidor = servidor;
    }

    public String getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public  String getServidor(){
        return servidor;
    }

    public  Agendamento getPeloServidor(String s){
        if (this.servidor == s) return this;
        else return null;
    }

    public Agendamento getPelaData(String d){
        if (this.data == d) return this;
        else return null;
    }

    public Agendamento getPelaHora(String h){
        if (this.hora == h) return this;
        else return null;
    }

    public Boolean verificaSeEstaNaLista(List<String> l){
        if (l.isEmpty())return false;
        else {
            for (String stri: l){
                if (this.getServidor().equals(stri))return true;
            }
            return false;
        }
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public  void setServidor(String servidor){ this.servidor = servidor;}
}
