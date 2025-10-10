package temadogrupo.persistencia.nitrite.servico;

import temadogrupo.modelo.*;
import temadogrupo.modelo.Valor.*;

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
     
    // Métodos com ID técnico
    /*
    public Cliente buscarPorId(NitriteId id) {        
        return (((ClienteRepositorioNitrite)repositorio).buscarPorCpf(null) PorId(id)); //Casting devido a não ser pra implementação
    }*/

    
    public void remover(NitriteId id) { 
        //repositorio.deletarPorId(id); 
    }

    
    // Métodos com chave de negócio, exigem casting pois não pertencem ao contrato
    public Cliente buscarPorCpf(Cpf cpf) { 
        return (((ClienteRepositorioNitrite)repositorio).buscarPorCpf(cpf)); //Casting devido a não ser pra implementação
    }


    public void deletarClientePorCpf(Cpf cpf) { 
        //repositorio.deletarPorMatricula(matricula); 
    }
          

}
