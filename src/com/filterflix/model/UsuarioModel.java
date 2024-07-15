package com.filterflix.model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private String email;
    private String senha;
    private List<PerfilModel> perfis;
    private PerfilModel perfilAtivo;

    public UsuarioModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.perfis = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PerfilModel> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<PerfilModel> perfis) {
        this.perfis = perfis;
    }

    public void adicionarPerfil(PerfilModel perfil) {
        perfis.add(perfil);
    }

    public PerfilModel encontrarPerfilPorNome(String nome) {
        for (PerfilModel perfil : perfis) {
            if (perfil.getNome().equalsIgnoreCase(nome)) {
                return perfil;
            }
        }
        return null;
    }

    public PerfilModel getPerfilAtivo() {
        return perfilAtivo;
    }

    public void setPerfilAtivo(PerfilModel perfilAtivo) {
        this.perfilAtivo = perfilAtivo;
    }
}