package java.com.filterflix.model;

import java.util.HashMap;

public class BancoDadosUsuarios {
    private HashMap<String, Usuario> usuarios;

    public BancoDadosUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.put(usuario.getEmail(), usuario);
    }

    public Usuario autenticarUsuario(String email, String senha) {
        Usuario usuario = this.usuarios.get(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return this.usuarios.get(email);
    }
}
