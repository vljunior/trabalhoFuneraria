package temadogrupo.modelo;

import temadogrupo.modelo.Valor.*;

public class Cliente extends Pessoa{
    
    private Endereco    endereco;
    private String      nomeContato;
    private String      nomeResponsavel;
    private String      grauParentescoFalecido;

    //Devido ao Nitrite, precisa ter
    public  Cliente(){

    }


    public Cliente(Endereco endereco, String nomeContato, String nomeResponsavel, String grauParentescoFalecido) {
        this.endereco = endereco;
        this.nomeContato = nomeContato;
        this.nomeResponsavel = nomeResponsavel;
        this.grauParentescoFalecido = grauParentescoFalecido;
    }      

}
