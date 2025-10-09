package temadogrupo.persistencia.nitrite.repositorio;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.ObjectRepository;
import temadogrupo.modelo.Pessoa;
import java.util.List;

public class PessoaRepositorioNitrite {
    private final Nitrite bancoDeDadosNitrite;
    private final ObjectRepository<Pessoa> repositorio;

    public PessoaRepositorioNitrite(Nitrite bancoDeDadosNitrite) {
        
        this.bancoDeDadosNitrite = bancoDeDadosNitrite;
        //informar que "tabela" o repositorio representa
        this.repositorio = bancoDeDadosNitrite.getRepository(Pessoa.class);

    }

    public void salvar(Pessoa pessoa) {
        
        if (pessoa.getId() == null) {
            pessoa.setId(NitriteId.newId()); // gera id único
        }
        repositorio.update(pessoa, true); //ao inves de insert, aqui insere ou atualiza

        //aqui ver se pessoa é cliente ou falecido e garantir os campos...
    }

    public List<Pessoa> listarTodos() {        
        return repositorio.find().toList();
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

    public void atualizarAluno(Aluno aluno) {
        // Atualiza pelo campo @Id (matricula)
        repositorio.update(aluno, true); 
    }

    public void atualizarNomePorMatricula(String matricula, String novoNome) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            repositorio.update(aluno, true);
        }
    }
    */  
}