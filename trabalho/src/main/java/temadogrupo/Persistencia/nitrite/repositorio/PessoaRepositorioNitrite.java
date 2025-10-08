package temadogrupo.persistencia.nitrite.repositorio;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;

import temadogrupo.modelo.Pessoa;
import java.util.List;

public class PessoaRepositorioNitrite {
    private final Nitrite db;
    private final ObjectRepository<Pessoa> repositorio;

    public PessoaRepositorioNitrite() {
        this.db = Nitrite.builder()
                .filePath("pessoas.db")
                .openOrCreate("user", "password");
        this.repositorio = db.getRepository(Pessoa.class);
    }

    public void salvar(Pessoa pessoa) {
        repositorio.insert(pessoa);
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

    public void fechar() {
        db.close();
    }
}
