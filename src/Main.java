import java.com.filterflix.repository.*;
import java.com.filterflix.service.MidiaService;
import java.com.filterflix.service.UsuarioService;
import java.com.filterflix.system.Menu;

public class Main {
    public static void main(String[] args) {
        UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);

        MidiaRepository midiaRepository = new MidiaRepositoryImpl();
        MidiaService midiaService = new MidiaService(midiaRepository);

        Menu menu = new Menu(usuarioService, midiaService);
        menu.mostrarMenuInicial();
    }
}