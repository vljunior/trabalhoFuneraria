package temadogrupo.persistencia.nitrite.servico;

import temadogrupo.modelo.Falecido;
import temadogrupo.persistencia.nitrite.repositorio.FalecidoRepositorioNitrite;
import temadogrupo.persistencia.nitrite.repositorio.RepositorioInterface;

import org.dizitart.no2.NitriteId;
import java.util.List;

public class FalecidoServico extends ServicoAbstract {    

    public FalecidoServico(RepositorioInterface<Falecido> repositorio) {
        super(repositorio);  
    }

     
    // Métodos com ID técnico
    /*
    public Falecido buscarPorId(NitriteId id) {        
        return (((FalecidoRepositorioNitrite)repositorio).buscarPorCpf(null) PorId(id)); //Casting devido a não ser pra implementação
    }*/    

}
