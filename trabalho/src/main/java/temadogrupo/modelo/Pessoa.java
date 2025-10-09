package temadogrupo.modelo;

import java.util.UUID;

import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;

import temadogrupo.modelo.Valor.Endereco;

public class Pessoa {

    @Id
    private NitriteId   id;    
    

    private String      nome;
    private TipoPessoa  tipo;

    
    //Devido a esta necessidade do Nitrite a classe não pode ser
    //abstra por Nitrite exigir um construtor padrão
    public Pessoa() {
       
    }


    public Pessoa(String nome, TipoPessoa tipo) {        
        this.nome = nome;
        this.tipo = tipo;
    }


    public NitriteId getId() {
        return id;
    }


    public void setId(NitriteId id) {
        this.id = id;
    }

    


}
