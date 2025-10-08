package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;
import temadogrupo.persistencia.nitrite.repositorio.PessoaRepositorioNitrite;
import temadogrupo.persistencia.nitrite.servico.PessoaServico;
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

                                    int opcaoListar;
                                    do {
                                        opcaoListar = MenuPessoa.exibirListarPessoa();

                                        switch (opcaoListar) { //sem break, com uso de ->
                                            case 1 -> {                                                      
                                                PessoaRepositorioNitrite repositorio = new PessoaRepositorioNitrite();
                                                PessoaServico servico = new PessoaServico(repositorio);
                                                Video.cabecalho("Todos os clientes cadastrados:");
                                                List<Cliente> clientes = servico.listarClientes();
                                                for (Cliente cliente : clientes) {
                                                    System.out.println(cliente);
                                                }
                                            }   
                                            
                                            case 2 -> {                                                      
                                                PessoaRepositorioNitrite repositorio = new PessoaRepositorioNitrite();
                                                PessoaServico servico = new PessoaServico(repositorio);
                                                Video.cabecalho("Todos os falecidos cadastrados:");
                                                List<Falecido> falecidos = servico.listarFalecidos();
                                                for (Falecido falecido : falecidos) {
                                                    System.out.println(falecido);
                                                }
                                            } 
                                        } 
                                    } while (opcaoListar != 3);
                                }    
                                
                                case 3 -> {
                                    int opcaoCadatrar;
                                    do {
                                        opcaoCadatrar = MenuPessoa.exibirCadastrarPessoa();

                                        switch (opcaoCadatrar) { //sem break, com uso de ->
                                            case 1 -> {                                                      
                                                PessoaRepositorioNitrite repositorio = new PessoaRepositorioNitrite();
                                                PessoaServico servico = new PessoaServico(repositorio);
                                                //Implementando pra abstração            
                                                Pessoa cliente = new Cliente();
                                                //incrementar os atributos de Cliente
                                                //cliente.TipoPessoa = TipoPessoa.CLIENTE;
                                                servico.cadastrar(cliente);
                                            }          
                                            
                                            case 2 -> {       
                                                PessoaRepositorioNitrite repositorio = new PessoaRepositorioNitrite();
                                                PessoaServico servico = new PessoaServico(repositorio);                                             
                                                Pessoa falecido = new Falecido();
                                                //incrementar os atributos de Finado
                                                //falecido.TipoPessoa = TipoPessoa.FALECIDO;
                                                servico.cadastrar(falecido);

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
