package temadogrupo.crud;

import temadogrupo.modelo.Cliente;
import temadogrupo.modelo.Valor.Cpf;
import temadogrupo.modelo.Valor.Endereco;
import temadogrupo.utilitarios.*;

public class ClienteCrud {
  
    public static Cliente criarCliente() {

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

        return new Cliente (cpf, nome, endereco, contato, reponsavel, grauParentesco, telefone, email);
        
    }
}
