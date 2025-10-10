package temadogrupo.persistencia.nitrite.servico;

import temadogrupo.modelo.Falecido;
import temadogrupo.persistencia.nitrite.repositorio.FalecidoRepositorioNitrite;
import temadogrupo.persistencia.nitrite.repositorio.RepositorioInterface;

import org.dizitart.no2.NitriteId;
import java.util.List;

public class FalecidoServico {

    private final RepositorioInterface<Falecido> repositorio;

    public FalecidoServico(RepositorioInterface<Falecido> repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Falecido cliente) { 
        repositorio.salvar(cliente); 
    }

    public List<Falecido> listar() { 
        return repositorio.listarTodos(); 
    }    
     
    // Métodos com ID técnico
    /*
    public Falecido buscarPorId(NitriteId id) {        
        return (((FalecidoRepositorioNitrite)repositorio).buscarPorCpf(null) PorId(id)); //Casting devido a não ser pra implementação
    }*/

    
    public void remover(NitriteId id) { 
        //repositorio.deletarPorId(id); 
    }         

}
