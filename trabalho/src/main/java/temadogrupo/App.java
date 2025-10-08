package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;
import temadogrupo.persistencia.txt.ArquivoTextoRepositorio;
import temadogrupo.persistencia.txt.Repositorio;
import temadogrupo.persistencia.txt.Servico;

/*Estrutura

temadogrupo/
 ├─ modelo/                                 Entidades do domínio (Pessoa, Cliente, Falecido, TipoPessoa) 
 ├─ persistencia/
 ├──────────────/txt/                       Em geral generics pra persistência em TXT
 ├──────────────/nitrite/
 ├────────────────────── /persistencia/     Interfaces e classes de repositório (Repositorio<T>, PessoaRepositorioNitrite)
 ├────────────────────── /servico/          Regras de negócio (PessoaService)
 ├─ menu/          Menus e UI de console
 └─ App.java       Ponto de entrada

*/

public class App {

    private static ConfiguracaoSingleton configuracoesSistema;

    public static void iniciar(){        
        Video.mensagem("Carregando...");
        //Video.barraProgresso(50, 20); 
        configuracoesSistema = ConfiguracaoSingleton.getInstancia();      
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

        // ao finalizar o sistema, salva as configurações 
        configuracoesSistema.salvarConfiguracoes();
    }  
}
