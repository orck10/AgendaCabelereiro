package com.example.aluno.agendacabelereiro;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aluno on 25/08/2016.
 */
public class ListaDeAgendamento {
    List<Agendamento> agendamento = new LinkedList<Agendamento>();
    Conexao conexao = new Conexao();

    public void getAgendamento() {
        try {
            agendamento = conexao.sendGetAgendamento();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<String> retornaTodosClientes(){
        List<String> clientes = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            if(modelo.verificaSeEstaNaLista(clientes)) {
            }
            else {
                clientes.add(modelo.getCliente());
            }
        }
        return clientes;
    }

    public List<String> retornaTodosDias(){
        List<String> dias = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            dias.add(modelo.getData());
        }

        return dias;
    }

    public List<String> retornaTodasHoras(){
        List<String> horas = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            horas.add(modelo.getHora());
        }

        return horas;
    }

    public List<String> retornaTodosServidores(){
        List<String> servidores = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            if(modelo.verificaSeEstaNaLista(servidores)) {
            }
            else {
                servidores.add(modelo.getServidor());
            }
        }

        return servidores;
    }

    public List<String> retornaDiasAgendados(String servidor){
        List<String> dias = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            if(modelo.getServidor().equals(servidor)) {
                dias.add(modelo.getData());
            }
        }

        return dias;
    }

    public List<String> retornaHorasAgendadas(String servidor, String data){
        List<String> horas = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            if(modelo.getServidor().equals(servidor) && modelo.getData().equals(data) && !modelo.getCliente().equals("vago")) {
                horas.add(modelo.getHora());
            }
        }

        return horas;
    }

    public List<String> retornaHorasVagas(String servidor, String data){
        List<String> horas = new LinkedList<String>();

        for (Agendamento modelo: agendamento){
            if(modelo.getServidor().equals(servidor) && modelo.getData().equals(data) && modelo.getCliente().equals("vago")) {
                horas.add(modelo.getHora());
            }
        }

        return horas;
    }

    public List<Agendamento> retornaHorariosVagos(String nomeServidor){
        //Retorna uma busca pelo nome do servidor os agendamentos
        List<Agendamento> vago = new LinkedList<Agendamento>();
        for(Agendamento modelo: agendamento){
            if(modelo.getCliente() == "vago"){
                vago.add(modelo);
            }
        }
        return vago;
    }


}

