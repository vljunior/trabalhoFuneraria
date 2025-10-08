package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;

public class App {

    private static ConfiguracaoSingleton configuracoesSistema;

    public static void iniciar(){        
        Video.mensagem("Carregando...");
        Video.barraProgresso(50, 20); 
        configuracoesSistema = ConfiguracaoSingleton.getInstanciaSingleton();      
    }

    public static void main(String[] args) {

        iniciar();
        int opcaoPrincipal;

        do {
            opcaoPrincipal = MenuPrincipal.exibir();

            switch (opcaoPrincipal) {
                case 1 -> {
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuPessoa.exibir();
                        switch (opcaoPessoa) { //sem break, com uso de ->
                            case 1 -> { 

                            }                            
                        }
                    } while (opcaoPessoa != 5);
                }                      
            }
        } while (opcaoPrincipal != 4);

        Video.mensagemInfo("Saindo do sistema...");
    }  
}
