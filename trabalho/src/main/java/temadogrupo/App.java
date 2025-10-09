package temadogrupo;

import temadogrupo.utilitarios.*;
import temadogrupo.menu.*;
import temadogrupo.modelo.*;
import temadogrupo.persistencia.nitrite.repositorio.Database;
import temadogrupo.persistencia.nitrite.repositorio.ClienteRepositorioNitrite;

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

        Database.fecharDb(); //forçando caso sair do sistema de forma anormal.
        iniciar();
/* 
        Pessoa cliente = new Pessoa ("Lorenzon", TipoPessoa.CLIENTE);
        configuracoesSistema.getServicoPessoa().cadastrar(cliente);      

        
        List<Pessoa> clientes = configuracoesSistema.getServicoPessoa().listar();
        
        //Guardian clause, Fail first
        if (clientes == null) {
            Video.mensagemAlerta("Não há clientes cadastrados");
            Video.pausa();
            //Early break/return                                                   
            
        }                                                

        //happy path
        Video.cabecalho("Todos os clientes cadastrados:");
        for (Pessoa cliente1 : clientes) {
                System.out.println(cliente1);
        }     

        */
        //try {
            
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
                                                                                                
                                                List<Cliente> clientes = configuracoesSistema.getServicoCliente().listar();//Clientes();
                                                
                                                //Guardian clause, Fail first
                                                if (clientes == null) {
                                                    Video.mensagemAlerta("Não há clientes cadastrados");
                                                    Video.pausa();
                                                    //Early break/return                                                   
                                                    break;
                                                }                                                

                                                //happy path
                                                Video.cabecalho("Todos os clientes cadastrados:");
                                                for (Cliente cliente : clientes) {
                                                        System.out.println(cliente);
                                                }    
                                                
                                                Video.pausa();                                                
                                            }   
                                            
                                            case 2 -> {                                                                                                     

                                                /*List<Falecido> falecidos = servicoPessoa.listarFalecidos();

                                                //Guardian clause, Fail first
                                                if (falecidos == null) {
                                                    Video.mensagemAlerta("Não há clientes cadastrados");
                                                    //Early break/return
                                                    break;
                                                }

                                                //happy path
                                                Video.cabecalho("Todos os falecidos cadastrados:");                                               
                                                
                                                for (Falecido falecido : falecidos) {
                                                    System.out.println(falecido);
                                                }      */                                                       
                                                
                                                
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
                                                //Endereco endereco = new Endereco("89800000", "Rua tal", "100N", "Chapeso-SC");
                                                Cliente cliente = new Cliente (); //("Lorenzon", TipoPessoa.CLIENTE);
                                                configuracoesSistema.getServicoCliente().cadastrar(cliente);
                                                //incrementar os atributos de Cliente
                                                //cliente.TipoPessoa = TipoPessoa.CLIENTE;
                                                //configuracoesSistema.servicoPessoa.cadastrar(cliente);

                                                Video.pausa();

                                            }          
                                            
                                            case 2 -> {                                                                                                 
                                                Pessoa falecido = new Falecido();
                                                //incrementar os atributos de Finado
                                                //falecido.TipoPessoa = TipoPessoa.FALECIDO;
                                                //configuracoesSistema.servicoPessoa.cadastrar(falecido);
                                                
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
                        

        //} catch (Exception e) {
            
            //Video.mensagemErro("Erro não previsto registrado no log: " + e.getMessage());            
            //LogRepositorio log = new LogRepositorio();
            //.registrarExcecao(e, configuracoesSistema.getMaximoLinhasLog());
            
        //}              
        
        //finally {
            // ao finalizar o sistema, salva as configurações             
            configuracoesSistema.fecharDatabase();
            configuracoesSistema.salvarConfiguracoes();
        //}
    }
}
