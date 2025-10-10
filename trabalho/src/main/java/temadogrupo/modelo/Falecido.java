package temadogrupo.modelo;
import java.time.LocalDate;

public class Falecido extends Pessoa{

    private LocalDate dataObito;
    private String causaMorte;
    private String localObito;
    private int idade;
    private String certidaoObito;
    private String numeroDocumento;
    private String tipoDocumento;

    //Devido ao Nitrite, precisa ter
    public  Falecido(){

    }
    
    public Falecido(String nome, LocalDate dataObito,  String causaMorte,
                    String localObito, int idade, String certidaoObito,
                    String numeroDocumento, String tipoDocumento){                    

        super (nome);
        this.dataObito = dataObito;
        this.causaMorte = causaMorte;
        this.localObito = localObito;
        this.idade = idade;
        this.certidaoObito = certidaoObito; 
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;       
    }

    @Override
    public String toString() {

        return super.toString();/*  + "\n" +
               "Cliente [cpf= " + cpf + ", endereco=" + endereco + ", nomeContato=" + nomeContato + ", nomeResponsavel=" + nomeResponsavel
                + ", grauParentescoFalecido=" + grauParentescoFalecido + ", telefone=" + telefone + ", email=" + email
                + "]";*/
    }
    
}
