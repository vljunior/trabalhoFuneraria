package temadogrupo.persistencia.txt;

import java.util.List; 

//Usado conforme exemplo Lorenzon de Generics e persistência Serializable

public interface Repositorio<T> {
    void salvar(List<T> lista) throws Exception;
    List<T> listar() throws Exception;
}
