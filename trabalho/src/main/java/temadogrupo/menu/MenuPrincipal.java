package temadogrupo.menu;

import java.util.ArrayList;

public class MenuPrincipal {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Pessoas");
        opcoes.add("Contratos");
        opcoes.add("Sair");
        Menu menu = new Menu("Menu Principal", opcoes);
        return menu.exibir();
    }
<<<<<<< HEAD
}

=======
}
>>>>>>> dd5e17d9506ec1812f488a788b4ed20b6f7d63b8
