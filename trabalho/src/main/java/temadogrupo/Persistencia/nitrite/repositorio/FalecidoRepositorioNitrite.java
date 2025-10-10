package temadogrupo.persistencia.nitrite.repositorio;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import temadogrupo.modelo.Falecido;
import temadogrupo.utilitarios.Video;

import java.util.List;

public class FalecidoRepositorioNitrite implements RepositorioInterface<Falecido> {
    private final Nitrite bancoDeDadosNitrite;
    private final ObjectRepository<Falecido> repositorio;

    public FalecidoRepositorioNitrite(Nitrite bancoDeDadosNitrite) {       
        this.bancoDeDadosNitrite = bancoDeDadosNitrite;
        this.repositorio = bancoDeDadosNitrite.getRepository(Falecido.class);
    }

    @Override
    public boolean salvar(Falecido objeto) {

        Video.mensagem("Salvando: " + objeto);        
        
        if (objeto == null) {
            return false;
        }
        if (objeto.getId() == null) {
            objeto.setId(NitriteId.newId()); // gera id único
        }
        repositorio.insert(objeto);        
        return true;                
    }

    @Override
    public List<Falecido> listarTodos() {        
        return repositorio.find().toList();
    }      

    @Override
    public void deletar(Falecido objeto) {     

    }        

    @Override
    public void atualizar(Falecido objeto) {
        // Atualiza pelo campo @Id 
        repositorio.update(objeto, true); 
    }  
    
}
