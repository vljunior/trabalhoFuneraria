package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.crud.ClienteCrud;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;
import temadogrupo.modelo.Valor.Cpf;
import temadogrupo.persistencia.nitrite.repositorio.Database;
import temadogrupo.persistencia.nitrite.repositorio.ClienteRepositorioNitrite;
import temadogrupo.persistencia.txt.LogRepositorio;
import java.util.List;

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

    public static void main(String[] args) {

        Database.fecharDb(); //forçando caso sair do sistema de forma anormal.
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

                                    int opcaoListar;
                                    do {
                                        opcaoListar = MenuPessoa.exibirListarPessoa();
                                        switch (opcaoListar) { //sem break, com uso de ->
                                            case 1 -> {                                         
                                                ClienteCrud.listarClientes(configuracoesSistema.getServicoCliente());                                                
                                            }                                               
                                            case 2 -> {
                                            } 
                                        }                                         
                                    } while (opcaoListar != 3);
                                }    
                                
                                case 3 -> {
                                    int opcaoCadatrar;
                                    do {
                                        opcaoCadatrar = MenuPessoa.exibirCadastrarPessoa();
                                        switch (opcaoCadatrar) { 
                                            case 1 -> {                                                    
                                                ClienteCrud.criarCliente(configuracoesSistema.getServicoCliente());                                            }
                                            case 2 -> {                                                                                                 
                                                //Falecido
                                            }
                                        }
                                    } while (opcaoCadatrar != 3);
                                }
                            }
                        } while (opcaoPessoa != 6);
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
            configuracoesSistema.fecharDatabase();
            configuracoesSistema.salvarConfiguracoes();
        }
    }

    public static void iniciar(){        
        Video.mensagem("Carregando sistema...");
        //Video.barraProgresso(50, 20); 
        configuracoesSistema = ConfiguracaoSingleton.getInstancia();      
    }    

}
