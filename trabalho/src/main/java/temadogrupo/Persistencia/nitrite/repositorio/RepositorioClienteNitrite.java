package temadogrupo.persistencia.nitrite.repositorio;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import temadogrupo.modelo.Cliente;
import temadogrupo.modelo.Valor.Cpf;
import temadogrupo.utilitarios.Video;

import java.util.List;

public class RepositorioClienteNitrite implements RepositorioInterface<Cliente> {
    private final Nitrite bancoDeDadosNitrite;
    private final ObjectRepository<Cliente> repositorio;

    public ClienteRepositorioNitrite(Nitrite bancoDeDadosNitrite) {
        
        this.bancoDeDadosNitrite = bancoDeDadosNitrite;
        //informar que "tabela" o repositorio representa
        this.repositorio = bancoDeDadosNitrite.getRepository(Cliente.class);

    }

    @Override
    public boolean salvar(Cliente objeto) {

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
    public List<Cliente> listarTodos() {        
        return repositorio.find().toList();
    }

    
    // Buscar por CPF (chave de negócio)
    public Cliente buscarPorCpf(Cpf cpf) {
        return repositorio.find(ObjectFilters.eq("cpf", cpf.getNumero()))
                   .firstOrDefault();
    }

    @Override
    public void deletar(Cliente objeto) {
        //repositorio.remove(ObjectFilters.eq("cpf", objeto.getNumero()));

    }        

    // Deletar por Cpf
    public void deletarPorCpf(Cpf cpf) {
        //repositorio.remove(ObjectFilters.eq("cpf", cpf.getNumero()));
    }


    @Override
    public void atualizar(Cliente objeto) {
        // Atualiza pelo campo @Id 
        repositorio.update(objeto, true); 
    }
    
    /*
    

    public void atualizarNomePorMatricula(String matricula, String novoNome) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            repositorio.update(aluno, true);
        }
    }
    */  
}