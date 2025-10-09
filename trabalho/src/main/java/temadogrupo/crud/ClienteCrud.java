package temadogrupo.crud;

import temadogrupo.modelo.Cliente;
import temadogrupo.modelo.Valor.Cpf;
import temadogrupo.utilitarios.*;

public class ClienteCrud {
  
    public static Cliente criarCliente() {

        Video.limparTela();
        Video.cabecalho ("Cadastrar cliente!"); 
        
        Video.mensagem("Informe os dados!");

        System.out.print("CPF: ");

        String cpfInput = Teclado.readString("Cpf: ");
        //Cpf cpf = new Cpf(cpfInput);

        String nome = Teclado.readString("Nome:");
        String rua = Teclado.readString("Rua:");
        String numero = Teclado.readString("Número:");
        String cidade = Teclado.readString("Cidade:");
        String uf = Teclado.readString("UF:");
        String cep = Teclado.readString("Cep:");

        //Endereco endereco = new Endereco(rua, numero, cidade);

        String contato = Teclado.readString("Nome do Contato:");
        String reposnsavel = Teclado.readString("Nome do Responsável:");
        String grauParentesco = Teclado.readString("Grau de Parentesco:");
        String telefone = Teclado.readString("Telefone de contato:");
        String email = Teclado.readString("e-mail de contato:");

        return null; //new Cliente(); //é privado vai dar pau Criar o construtor correto e chamar com os atributos
    }
}
