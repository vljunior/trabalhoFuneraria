package temadogrupo.modelo;
import temadogrupo.modelo.Valor.*;


public class Cliente extends Pessoa{
    
    private Endereco    endereco;
    private String      nomeContato;
    private String      nomeResponsavel;
    private String      grauParentescoFalecido;
    private String      telefone;
    private String      email;
    
    
    //Devido ao Nitrite, precisa ter
    public  Cliente(){

    }

    //Se não fizer assim, não vai persistir os dados herdados...
    public Cliente(//atributos de pessoa
                    Cpf cpf, String nome, 
                    //+Especializados
                    Endereco endereco, String nomeContato, String nomeResponsavel, String grauParentescoFalecido,
                    String telefone, String email) {

        super (cpf, nome);

        this.endereco = endereco;
        this.nomeContato = nomeContato;
        this.nomeResponsavel = nomeResponsavel;
        this.grauParentescoFalecido = grauParentescoFalecido;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {

        return super.toString() + "\n" +
               "Cliente [endereco=" + endereco + ", nomeContato=" + nomeContato + ", nomeResponsavel=" + nomeResponsavel
                + ", grauParentescoFalecido=" + grauParentescoFalecido + ", telefone=" + telefone + ", email=" + email
                + "]";
    }

         

}
