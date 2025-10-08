package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;
import temadogrupo.persistencia.txt.LogRepositorio;


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
        Video.mensagem("Carregando sistema...");
        //Video.barraProgresso(50, 20); 
        configuracoesSistema = ConfiguracaoSingleton.getInstancia();      
    }

    public static void main(String[] args) {

        iniciar();
        try {
            
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
                                
                                case 3 -> {
                                    int opcaoCadatrar;
                                    do {
                                        opcaoCadatrar = MenuPessoa.exibirCadastrarPessoa();
                                        switch (opcaoCadatrar) { //sem break, com uso de ->
                                            case 1 -> {                                     
                                                //Implementando pra abstração            
                                                Pessoa cliente = new Cliente();
                                                //incrementar os atributos de Cliente
                                            }           
                                            
                                            case 2 -> {                                                    
                                                Pessoa falecido = new Falecido();
                                                //incrementar os atributos de Finado

                                            }
                                        }
                                    } while (opcaoCadatrar != 3);
                                }                                
                            }
                        } while (opcaoPessoa != 5);
                    }                      

                    
                }
            } while (opcaoPrincipal != 4);

            Video.mensagemInfo("Saindo do sistema...");            
                        

        } catch (Exception e) {
            
            Video.mensagemErro("Erro não previsto registrado no log: " + e.getMessage());            
            LogRepositorio log = new LogRepositorio();
            log.registrarExcecao(e, configuracoesSistema.getMaximoLinhasLog());
            
        }              
        
        finally {
            // ao finalizar o sistema, salva as configurações 
            configuracoesSistema.salvarConfiguracoes();
        }
    }
}
