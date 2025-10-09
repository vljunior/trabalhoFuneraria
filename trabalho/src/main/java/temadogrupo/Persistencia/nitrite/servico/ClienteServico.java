package temadogrupo.persistencia.nitrite.servico;

import temadogrupo.modelo.*;
import temadogrupo.persistencia.nitrite.repositorio.ClienteRepositorioNitrite;
import temadogrupo.persistencia.nitrite.repositorio.RepositorioInterface;

import org.dizitart.no2.NitriteId;
import java.util.List;

public class ClienteServico {

    private final RepositorioInterface<Cliente> repositorio;

    public ClienteServico(RepositorioInterface<Cliente> repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Cliente cliente) { 
        repositorio.salvar(cliente); 
    }

    public List<Cliente> listar() { 
        return repositorio.listarTodos(); 
    }    
/*     
    // Métodos com ID técnico
    public Aluno buscarAluno(NitriteId id) { 
        return repositorio.buscarPorId(id); 
    }
    */
    
    public void remover(NitriteId id) { 
        //repositorio.deletarPorId(id); 
    }

    /*
    // Métodos com chave de negócio
    public Aluno buscarPorMatricula(String matricula) { 
        return repositorio.buscarPorMatricula(matricula);     
    }
        

    public void removerPorMatricula(String matricula) { 
        repositorio.deletarPorMatricula(matricula); 
    }
        */
          

}
