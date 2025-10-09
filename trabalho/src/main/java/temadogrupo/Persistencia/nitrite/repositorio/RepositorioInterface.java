package temadogrupo.persistencia.nitrite.repositorio;

import java.util.List;

public interface RepositorioInterface<T> {

    //Estas ações são por @Id Nitrite
     public void salvar(T objeto);
     public List<T> listarTodos();
     public void atualizar(T objeto);
     void deletar(T objeto); 

}
