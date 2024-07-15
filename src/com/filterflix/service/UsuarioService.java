package com.filterflix.service;

import com.filterflix.model.MidiaModel;
import com.filterflix.model.PerfilModel;
import com.filterflix.model.UsuarioModel;
import com.filterflix.repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioModel usuarioLogado;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioLogado = null;
    }

    public void registrarUsuario(String email, String senha) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("E-mail inválido.");
        }
        UsuarioModel usuario = new UsuarioModel(email, senha);
        usuarioRepository.salvarUsuario(usuario);
    }

    public boolean autenticar(String email, String senha) {
        UsuarioModel usuario = usuarioRepository.encontrarUsuarioPorEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            usuarioLogado = usuario;
            return true;
        }
        return false;
    }

    public UsuarioModel getUsuario(String email) {
        return usuarioRepository.encontrarUsuarioPorEmail(email);
    }

    public UsuarioModel getUsuarioLogado() {
        return usuarioLogado;
    }

    public void atualizarUsuario(UsuarioModel usuario) {
        usuarioRepository.salvarUsuario(usuario); // Atualiza o usuário no repositório
    }

    public void criarPerfil(String email, String nome, boolean infantil) {
        UsuarioModel usuario = usuarioRepository.encontrarUsuarioPorEmail(email);
        if (usuario != null) {
            PerfilModel perfil = new PerfilModel(nome, infantil);
            usuario.adicionarPerfil(perfil);
            atualizarUsuario(usuario);
        }
    }

    public void definirPerfilAtivo(String email, String nomePerfil) {
        UsuarioModel usuario = usuarioRepository.encontrarUsuarioPorEmail(email);
        if (usuario != null) {
            PerfilModel perfil = usuario.encontrarPerfilPorNome(nomePerfil);
            if (perfil != null) {
                usuario.setPerfilAtivo(perfil);
                atualizarUsuario(usuario);
            } else {
                System.out.println("Perfil não encontrado.");
            }
        }
    }

    public void salvarMidiaNoPerfilAtivo(MidiaModel midia) {
        UsuarioModel usuario = getUsuarioLogado();
        if (usuario != null) {
            PerfilModel perfilAtivo = usuario.getPerfilAtivo();
            if (perfilAtivo != null) {
                if (perfilAtivo.podeAcessarMidia(midia)) {
                    perfilAtivo.adicionarFavorito(midia);
                    atualizarUsuario(usuario);
                } else {
                    System.out.println("Perfil infantil não pode acessar mídias com classificação acima de 14 anos.");
                }
            } else {
                System.out.println("Nenhum perfil ativo encontrado.");
            }
        } else {
            System.out.println("Nenhum usuário logado.");
        }
    }

    public void avaliarMidiaNoPerfilAtivo(MidiaModel midia, int nota) {
        UsuarioModel usuario = getUsuarioLogado();
        if (usuario != null) {
            PerfilModel perfilAtivo = usuario.getPerfilAtivo();
            if (perfilAtivo != null) {
                perfilAtivo.avaliarMidia(midia, nota);
                atualizarUsuario(usuario);
            } else {
                System.out.println("Nenhum perfil ativo encontrado.");
            }
        } else {
            System.out.println("Nenhum usuário logado.");
        }
    }

    public void sairDoPerfil() {
        UsuarioModel usuario = getUsuarioLogado();
        if (usuario != null) {
            usuario.setPerfilAtivo(null);
            atualizarUsuario(usuario);
        } else {
            System.out.println("Nenhum usuário logado.");
        }
    }

    public UsuarioModel obterUsuarioLogado() {
        return usuarioLogado;
    }

    public UsuarioModel obterUsuarioPorEmail(String email) {
        return usuarioRepository.encontrarUsuarioPorEmail(email);
    }

    public boolean isValidEmail(String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }
}