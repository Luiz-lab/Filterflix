package java.com.filterflix.repository;

import java.com.filterflix.model.UsuarioModel;

public interface UsuarioRepository {
    void salvarUsuario(UsuarioModel usuario);
    UsuarioModel encontrarUsuarioPorEmail(String email);
}