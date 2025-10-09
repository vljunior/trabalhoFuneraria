package temadogrupo.persistencia.nitrite.repositorio;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.ObjectRepository;
import temadogrupo.modelo.Cliente;
import java.util.List;

public class ClienteRepositorioNitrite implements RepositorioInterface<Cliente> {
    private final Nitrite bancoDeDadosNitrite;
    private final ObjectRepository<Cliente> repositorio;

    public ClienteRepositorioNitrite(Nitrite bancoDeDadosNitrite) {
        
        this.bancoDeDadosNitrite = bancoDeDadosNitrite;
        //informar que "tabela" o repositorio representa
        this.repositorio = bancoDeDadosNitrite.getRepository(Cliente.class);

    }

    @Override
    public void salvar(Cliente objeto) {
        
        if (objeto.getId() == null) {
            objeto.setId(NitriteId.newId()); // gera id único
        }
        repositorio.update(cliente, true); //ao inves de insert, aqui insere ou atualiza

        //aqui ver se pessoa é cliente ou falecido e garantir os campos...
    }

    @Override
    public List<Cliente> listarTodos() {        
        return repositorio.find().toList();
    }

    @Override
    public deletar (Cliente objeto){

    }

    /*
    // Buscar por matrícula (chave de negócio)
    public Pessoa buscarPorMatricula(String matricula) {
        return repositorio.find(ObjectFilters.eq("matricula", matricula))
                   .firstOrDefault();
    }

    // Deletar por matrícula
    public void deletarPorMatricula(String matricula) {
        repositorio.remove(ObjectFilters.eq("matricula", matricula));
    }

    //update - dar insert com o mesmo id
*/
    @Override
    public void atualizar(Cliente objeto) {
        // Atualiza pelo campo @Id (matricula)
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