package temadogrupo.modelo;

import temadogrupo.modelo.Valor.*;
import java.util.UUID;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
public abstract class Pessoa {

    @Id
    private NitriteId   id;    
    
    private Cpf         cpf;
    private String      nome;      

    
    //Mesmo abstract é possível construtor, mas não instancia
    //Exigência do Nitrite para poder levar os atributos 
    //para as derivadas    

    public Pessoa(){        
    }

    public Pessoa(Cpf cpf, String nome) {
        //o id é automático pelo Nitrite
        this.cpf = cpf;
        this.nome = nome;
    }

    public NitriteId getId() {
        return id;
    }

    public void setId(NitriteId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pessoa [id=" + id + ", cpf=" + cpf + ", nome=" + nome + "]";
    }

}
