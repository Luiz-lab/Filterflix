package com.filterflix.system;

import com.filterflix.model.*;
import com.filterflix.service.MidiaService;
import com.filterflix.service.UsuarioService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private UsuarioService usuarioService;
    private MidiaService midiaService;
    private Scanner scanner;

    public Menu(UsuarioService usuarioService, MidiaService midiaService) {
        this.usuarioService = usuarioService;
        this.midiaService = midiaService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuInicial() {
        while (true) {
            System.out.println("1. Entrar");
            System.out.println("2. Criar Conta");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    if (entrar()) {
                        mostrarMenuCatalogo();
                    }
                    break;
                case 2:
                    criarConta();
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        }
    }

    private void criarConta() {
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        usuarioService.registrarUsuario(email, senha);
        System.out.println("Conta criada com sucesso.");
    }

    private boolean entrar() {
        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();
        if (usuarioService.autenticar(email, senha)) {
            System.out.println("Login bem-sucedido.");
            return true;
        } else {
            System.out.println("E-mail ou senha incorretos.");
            return false;
        }
    }

    private void mostrarMenuCatalogo() {
        System.out.println("____________________________________________________________________________________________");
        System.out.println("\nBem-vindo à Filterflix!\n");

        while (true) {
            List<FilmeModel> filmes = midiaService.listarFilmes();
            List<SerieModel> series = midiaService.listarSeries();

            if (!filmes.isEmpty()) {
                System.out.println("Filmes:");
                for (int i = 0; i < filmes.size(); i++) {
                    System.out.println((i + 1) + ". " + filmes.get(i).getCapa());
                    System.out.println(filmes.get(i).getTitulo());
                }
                System.out.println();
            }

            if (!series.isEmpty()) {
                System.out.println("Séries:");
                for (int i = 0; i < series.size(); i++) {
                    System.out.println((i + 1 + filmes.size()) + ". " + series.get(i).getCapa());
                    System.out.println(series.get(i).getTitulo());
                }
                System.out.println("__________________________________________________________________________________________________");
                System.out.println();
            }

            System.out.println("Escolha uma mídia para reproduzir (ou 0 para sair): ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            if (escolha == 0) {
                System.out.println("\nSaindo do catálogo...");
                return;
            }

            if (escolha > 0 && escolha <= filmes.size()) {
                reproduzirMidia(filmes.get(escolha - 1));
            } else if (escolha > filmes.size() && escolha <= filmes.size() + series.size()) {
                reproduzirMidia(series.get(escolha - filmes.size() - 1));
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private void reproduzirMidia(MidiaModel midia) {
        System.out.println("Reproduzindo " + midia.getTitulo() + "...");

    }
}