package java.com.filterflix.model;

import java.util.ArrayList;

public class UsuarioModel {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<PerfilModel> perfis;

    public UsuarioModel(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfis = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public ArrayList<PerfilModel> getPerfis() {
        return perfis;
    }

    public void adicionarPerfil(PerfilModel perfil) {
        this.perfis.add(perfil);
    }
}
