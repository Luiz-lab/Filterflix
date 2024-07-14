package java.com.filterflix.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioModel {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<PerfilModel<?>> perfis;

    public UsuarioModel(String email, String senha) {
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

    public ArrayList<PerfilModel<?>> getPerfis() {
        return perfis;
    }

    public void adicionarPerfil(PerfilModel<?> perfilModel) {
        this.perfis.add(perfilModel);
    }

    public void removerPerfil(PerfilModel<?> perfilModel) {
        this.perfis.remove(perfilModel);
    }

    public Optional<PerfilModel<?>> buscarPerfilPorTipo(boolean isInfantil) {
        return perfis.stream()
                .filter(perfilModel -> perfilModel.isInfantil() == isInfantil)
                .findFirst();
    }
}
