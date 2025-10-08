package temadogrupo.modelo;

import java.util.UUID;

import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;

public class Pessoa {

    @Id
    private NitriteId   id;    
    private String      nome;
    private TipoPessoa  tipo;

    public Pessoa() {
       
    }

}
