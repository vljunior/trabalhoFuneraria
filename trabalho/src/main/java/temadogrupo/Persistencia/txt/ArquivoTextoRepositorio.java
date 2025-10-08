package temadogrupo.persistencia.txt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Usado conforme exemplo Lorenzon de Generics e persistência Serializable

public class ArquivoTextoRepositorio<T extends SerializableTXT> implements Repositorio<T> {
    private final String arquivo;
    private final T prototipo; // objeto "modelo" para reconstruir

    public ArquivoTextoRepositorio(String arquivo, T prototipo) {
        this.arquivo = arquivo;
        this.prototipo = prototipo;
    }

    @Override
    public void salvar(List<T> lista) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (T obj : lista) {
                pw.println(obj.toSerializableTxt()); //por isso <T extends SerializableTxt>
            }
        }
    }

    @Override
    public List<T> listar() throws IOException {
        List<T> out = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(arquivo))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                @SuppressWarnings("unchecked")
                T obj = (T) prototipo.fromSerializableTxt(linha); //por isso <T extends SerializableTxt>
                out.add(obj);
            }
        }
        return out;
    }
}
