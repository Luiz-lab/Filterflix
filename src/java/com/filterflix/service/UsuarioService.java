package java.com.filterflix.service;

import java.com.filterflix.model.UsuarioModel;
import java.com.filterflix.repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioModel usuarioLogado; // Variável para armazenar o usuário logado

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioLogado = null; // Inicialmente, não há usuário logado
    }

    public void registrarUsuario(String email, String senha) {
        UsuarioModel usuario = new UsuarioModel(email, senha);
        usuarioRepository.salvarUsuario(usuario);
    }

    public boolean autenticar(String email, String senha) {
        UsuarioModel usuario = usuarioRepository.encontrarUsuarioPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            usuarioLogado = usuario; // Armazena o usuário logado
            return true;
        }
        return false;
    }

    public UsuarioModel obterUsuarioLogado() {
        return usuarioLogado;
    }
}