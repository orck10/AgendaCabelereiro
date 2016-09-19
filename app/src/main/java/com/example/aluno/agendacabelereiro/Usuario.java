package com.example.aluno.agendacabelereiro;

/**
 * Created by Jorge on 12/09/2016.
 */
public class Usuario {
    private String cpf;
    private String nome;
    private String celular;
    private String senha;
    private String tipoDeUsuario;

    public Usuario(String cpf, String nome, String numeroCel, String senha, String tipoDeUsuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.celular = numeroCel;
        this.senha = senha;
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
}
