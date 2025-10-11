package temadogrupo.menu;

import java.util.ArrayList;

public class MenuPrincipal {

    public static int exibir(String nome) {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Pessoas");
        opcoes.add("Contratos");
        opcoes.add("Configuracoes");
        opcoes.add("Sair");
        Menu menu = new Menu(nome, opcoes);
        return menu.exibir();
    }
}

