package com.filterflix.repository;

import com.filterflix.model.UsuarioModel;

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

    @Override
    public void atualizarUsuario(UsuarioModel usuario) {
        usuarios.put(usuario.getEmail(), usuario);
    }
}