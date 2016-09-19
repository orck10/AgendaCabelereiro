package com.example.aluno.agendacabelereiro;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Jorge on 12/09/2016.
 */
public class ListaDeUsuario {

    private List<Usuario> listaDeUsuario = new LinkedList<Usuario>();
    Conexao conexao = new Conexao();

    public void getUsuario(){
        try {
            listaDeUsuario = conexao.sendGetUsuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
