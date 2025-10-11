package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.controllerview.*;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;
import temadogrupo.modelo.Valor.Cpf;
import temadogrupo.persistencia.nitrite.repositorio.Database;
import temadogrupo.persistencia.nitrite.repositorio.*;
import temadogrupo.persistencia.txt.LogRepositorio;
import java.util.List;

/*Estrutura

temadogrupo/
 ├─ modelo/                                 Entidades do domínio (Pessoa, Cliente, Falecido, TipoPessoa) 
 ├─                                         Video e Teclado
 ├─ controllerview                          Sem ser MVC, mas juntando view e controller no crud
 ├─ excecoes                                Se criar minhas exceções 
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
        
        iniciar();
        try {
            
            int opcaoPrincipal;

            do {
                opcaoPrincipal = MenuPrincipal.exibir(configuracoesSistema.getNomeFuneraria());

                switch (opcaoPrincipal) {
                    case 1 -> {
                        tratarMenuPessoa();
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
            // ao finalizar o sistema, fehca o banco e salva as configurações             
            configuracoesSistema.fecharDatabase();
            configuracoesSistema.salvarConfiguracoes();
        }
    }

    public static void iniciar(){        
        Video.mensagem("Carregando sistema...");
        //Video.barraProgresso(50, 20); 
        configuracoesSistema = ConfiguracaoSingleton.getInstancia();      
    }    

    public static void tratarMenuPessoa(){
        int opcaoPessoa;
        do {
            opcaoPessoa = MenuPessoa.exibir();
            switch (opcaoPessoa) { 
                case 1 -> {
                    int opcaoListar;
                    do {
                        opcaoListar = MenuPessoa.exibirListarPessoa();
                        switch (opcaoListar) { 
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
                                ClienteCrud.criarCliente(configuracoesSistema.getServicoCliente());   
                            }                                         
                            case 2 -> {                                                                                                 
                                FalecidoCrud.criarFalecido(configuracoesSistema.getServicoFalecido());                                            
                            }
                        }
                    } while (opcaoCadatrar != 3);
                }
            }
        } while (opcaoPessoa != 6);
    }
}
