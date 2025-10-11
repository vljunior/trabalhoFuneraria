package temadogrupo.menu;

import java.util.ArrayList;

public class MenuPessoa {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Listar");
        opcoes.add("Localizar");
        opcoes.add("Cadastrar");
        opcoes.add("Atualizar");
        opcoes.add("Excluir");
        opcoes.add("Voltar");
        Menu menu = new Menu("CRUD Pessoa!", opcoes);
        return menu.exibir();
    }

    public static int exibirCadastrarPessoa() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Cliente");
        opcoes.add("Falecido");
        opcoes.add("Voltar");
        Menu menu = new Menu("Cadatrar pessoa!", opcoes);
        return menu.exibir();
    }

    public static int exibirListarPessoa() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Clientes");
        opcoes.add("Falecidos");
        opcoes.add("Voltar");
        Menu menu = new Menu("Listar pessoas!", opcoes);
        return menu.exibir();
    }
}
