package temadogrupo.Persistencia.txt;

public interface SerializableTXT {
    String toSerializableTxt();
    SerializableTXT fromSerializableTxt(String linha);
}
