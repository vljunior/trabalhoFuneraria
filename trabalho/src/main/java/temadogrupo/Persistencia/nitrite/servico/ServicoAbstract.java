package temadogrupo.persistencia.nitrite.servico;

import temadogrupo.persistencia.nitrite.repositorio.RepositorioInterface;
import temadogrupo.modelo.Cliente;
import temadogrupo.modelo.Pessoa;
import org.dizitart.no2.NitriteId;
import java.util.List;

public abstract class ServicoAbstract<T> {

    private final RepositorioInterface<T> repositorio;

    public ServicoAbstract(RepositorioInterface<T> repositorio) {
        this.repositorio = repositorio;
    }

    public criarServico(RepositorioInterface<T> repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(T objeto) { 
        repositorio.salvar(objeto); 
    }

    public List<T> listar() { 
        return repositorio.listarTodos(); 
    }    
     
    //Aqui todos podem usar este  
    public void remover(NitriteId id) { 
        repositorio.deletarPorId(id); 
    }

    /*

    // Métodos com chave de negócio, exigem casting pois não pertencem ao contrato
    public Cliente buscarPorCpf(Cpf cpf) { 
        return (((ClienteRepositorioNitrite)repositorio).buscarPorCpf(cpf)); //Casting devido a não ser pra implementação
    }


    public void deletarClientePorCpf(Cpf cpf) { 
        //repositorio.deletarPorMatricula(matricula); 
    }

    */
          

}

