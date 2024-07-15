package com.filterflix.model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private String email;
    private String senha;
    private List<PerfilModel> perfis;

    public UsuarioModel(String email, String senha) {
        this.email = email;
        this.senha = senha;
        this.perfis = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<PerfilModel> getPerfis() {
        return perfis;
    }

    public void adicionarPerfil(PerfilModel perfil) {
        perfis.add(perfil);
    }
}