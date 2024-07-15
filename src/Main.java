import com.filterflix.repository.MidiaRepository;
import com.filterflix.repository.MidiaRepositoryImpl;
import com.filterflix.repository.UsuarioRepository;
import com.filterflix.repository.UsuarioRepositoryImpl;
import com.filterflix.service.MidiaService;
import com.filterflix.service.UsuarioService;
import com.filterflix.system.Menu;

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