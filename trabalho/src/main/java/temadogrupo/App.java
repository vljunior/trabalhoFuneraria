package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.menu.*;

public class App {

    public static void iniciar(){
        
        Video.mensagem("Carregando...");
        Video.barraProgresso(50, 15);
        Video.limparTela();
        Video.cabecalho ("Nossa aplicação!");
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
        } while (opcaoPrincipal != 3);

        Video.mensagemInfo("Saindo do sistema...");
    }  
}
