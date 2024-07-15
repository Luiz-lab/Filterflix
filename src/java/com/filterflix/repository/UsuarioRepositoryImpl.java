package java.com.filterflix.repository;

import java.com.filterflix.model.UsuarioModel;
import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private Map<String, UsuarioModel> usuarios = new HashMap<>();

    @Override
    public void salvarUsuario(UsuarioModel usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }

    @Override
    public UsuarioModel encontrarUsuarioPorEmail(String email) {
        return usuarios.get(email);
    }
}