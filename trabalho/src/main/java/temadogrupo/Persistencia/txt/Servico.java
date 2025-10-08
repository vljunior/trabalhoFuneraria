package temadogrupo.persistencia.txt;

import java.util.List;

//Usado conforme exemplo Lorenzon de Generics e persistência Serializable

public class Servico<T extends SerializableTXT> {
    private Repositorio<T> repositorio; // Injeção, associação

    public Servico(Repositorio<T> repositorio) {
        this.repositorio = repositorio;
    }

    public void salvar(List<T> lista) throws Exception {
        repositorio.salvar(lista);
    }

    public List<T> carregar() throws Exception {
        return repositorio.listar();
    }
}