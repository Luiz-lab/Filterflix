package java.com.filterflix.model;

import java.util.HashMap;

public class BancoDadosUsuariosModel {
    private HashMap<String, UsuarioModel> usuarios;

    public BancoDadosUsuariosModel() {
        this.usuarios = new HashMap<>();
    }

    public void adicionarUsuario(UsuarioModel usuarioModel) {
        this.usuarios.put(usuarioModel.getEmail(), usuarioModel);
    }

    public UsuarioModel autenticarUsuario(String email, String senha) {
        UsuarioModel usuarioModel = this.usuarios.get(email);
        if (usuarioModel != null && usuarioModel.getSenha().equals(senha)) {
            return usuarioModel;
        }
        return null;
    }

    public UsuarioModel buscarUsuarioPorEmail(String email) {
        return this.usuarios.get(email);
    }
}
