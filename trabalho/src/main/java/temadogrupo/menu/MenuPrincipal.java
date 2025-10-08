package temadogrupo.menu;

import java.util.ArrayList;

public class MenuPrincipal {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Pessoas");
        opcoes.add("Contratos");
        opcoes.add("Configurações");
        opcoes.add("Sair");
        Menu menu = new Menu("Menu - Funerária Lorenzon", opcoes);
        return menu.exibir();
    }
}

