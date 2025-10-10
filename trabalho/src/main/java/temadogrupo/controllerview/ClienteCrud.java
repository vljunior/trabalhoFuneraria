package temadogrupo.controllerview;

import java.util.List;

import temadogrupo.modelo.Cliente;
import temadogrupo.modelo.Valor.Cpf;
import temadogrupo.modelo.Valor.Endereco;
import temadogrupo.utilitarios.*;
import temadogrupo.persistencia.nitrite.servico.ClienteServico;

public class ClienteCrud {
  
    public static Cliente criarCliente(ClienteServico servico) {

        Video.limparTela();
        Video.cabecalho ("Cadastrar cliente!");        
        Video.mensagem("Informe os dados!");
        System.out.print("CPF: ");

        String cpfInput = Teclado.readString("Cpf: "); //Venha o que vier...
        Cpf cpf;

        try {            
            cpf = new Cpf(cpfInput);
            Video.mensagemOk("Cpf ok: " + cpf); //toString vem formatado
        } catch (IllegalArgumentException e){
            Video.mensagemErro(e.getMessage());
            Video.pausa();
            return null;
        }      

        String nome     = Teclado.readString("Nome:");
        String rua      = Teclado.readString("Rua:");
        String numero   = Teclado.readString("Número:");
        String cidade   = Teclado.readString("Cidade:");
        String estado   = Teclado.readString("UF:");
        String cep      = Teclado.readString("Cep:");

        Endereco endereco;
        try{            
            endereco = new Endereco (cep, rua, numero, cidade, estado);        
        } catch (IllegalArgumentException e) {
            Video.mensagemErro(e.getMessage());
            Video.pausa();
            return null;
        }

        String contato          = Teclado.readString("Nome do Contato:");
        String reponsavel       = Teclado.readString("Nome do Responsável:");
        String grauParentesco   = Teclado.readString("Grau de Parentesco:");
        String telefone         = Teclado.readString("Telefone de contato:");
        String email            = Teclado.readString("e-mail de contato:");

        Cliente novo;        

        try {        
            novo = new Cliente (cpf, nome, endereco, contato, reponsavel, grauParentesco, telefone, email);
            if (novo == null) {
                throw new Exception(); //Se não deu erro, mas voltou nulo, forço o erro
            }
            servico.cadastrar(novo);
            Video.pausa();
        } catch (Exception e) {                
                Video.mensagemErro("Não foi possível concluir o cadastro: " + e.getMessage());
                Video.pausa();
                return null;                    
        }       

        return novo;
        
    }     

    public static void deletarClientePorCpf(ClienteServico servico){

        Cpf cpf;

        Video.limparTela();                 

        try {
            cpf = new Cpf (Teclado.readString("Informe o Cpf:"));    
            Cliente cliente = servico.buscarPorCpf(cpf);
            Video.mensagem("Localizado: " + cliente);
            if (Video.confirmar("Deseja excluir?")) {
                servico.deletarClientePorCpf(cpf);
            }                
        } catch (IllegalArgumentException e) {  //ver outra exceção              
                Video.mensagemErro("Não foi possível localizar o cadastro: " + e.getMessage());
                Video.pausa();
                return;                    
        }      
        
    } 

    public static void listarClientes(ClienteServico servico){
        
        List<Cliente> clientes = servico.listar();                                                
        //Guardian clause, Fail first
        if (clientes == null) {
            Video.mensagemAlerta("Não há clientes cadastrados");
            Video.pausa();
            //Early break/return                                                   
            return;
        }                                                

        //happy path
        Video.cabecalho("Todos os clientes cadastrados:");
        for (Cliente cliente : clientes) {
                System.out.println(cliente);
        }    
        
        Video.pausa();                                                
    }

}
