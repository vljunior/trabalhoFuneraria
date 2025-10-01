package temadogrupo;

import temadogrupo.utilitarios.*;

public class App {
    public static void iniciar(){
        
        Video.mensagem("Carregando...");
        Video.barraProgresso(50, 15);
        Video.limparTela();
        Video.cabecalho ("Nossa aplicação!");
    }

    public static void main(String[] args) {
        iniciar();
    }
}
