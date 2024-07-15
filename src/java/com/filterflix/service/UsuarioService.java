package java.com.filterflix.service;

import java.com.filterflix.model.UsuarioModel;
import java.com.filterflix.repository.UsuarioRepository;
import java.com.filterflix.system.Autenticavel;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void registrarUsuario(String email, String senha) {
        UsuarioModel usuario = new UsuarioModel(email, senha);
        usuarioRepository.salvarUsuario(usuario);
    }

    public boolean autenticar(String email, String senha) {
        UsuarioModel usuario = usuarioRepository.encontrarUsuarioPorEmail(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}