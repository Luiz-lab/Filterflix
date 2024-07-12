package java.com.filterflix.model;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Perfil> perfis;

    public Usuario(String nome, String email, String senha) {
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

    public ArrayList<Perfil> getPerfis() {
        return perfis;
    }

    public void adicionarPerfil(Perfil perfil) {
        this.perfis.add(perfil);
    }
}
