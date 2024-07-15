package com.filterflix.repository;

import com.filterflix.model.UsuarioModel;

public interface UsuarioRepository {
    void salvarUsuario(UsuarioModel usuario);
    UsuarioModel encontrarUsuarioPorEmail(String email);
    void atualizarUsuario(UsuarioModel usuario); // Adicionado método para atualizar usuário
}