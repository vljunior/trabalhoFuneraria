package temadogrupo.persistencia.nitrite.servico;

import temadogrupo.modelo.*;
import temadogrupo.persistencia.nitrite.repositorio.PessoaRepositorioNitrite;
import org.dizitart.no2.NitriteId;
import java.util.List;

public class PessoaServico {

    private final PessoaRepositorioNitrite repositorio;

    public PessoaServico(PessoaRepositorioNitrite repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Pessoa pessoa) { 
        repositorio.salvar(pessoa); 
    }

    public List<Pessoa> listar() { 
        return repositorio.listarTodos(); 
    }

    public List<Cliente> listarClientes() { 
        // repositorio.listarTodos(); 
        return null;
    }

    public List<Falecido> listarFalecidos() { 
        //return repositorio.listarTodos(); 
        return null;
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
