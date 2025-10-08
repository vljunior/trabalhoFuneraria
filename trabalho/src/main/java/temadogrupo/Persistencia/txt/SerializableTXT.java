package temadogrupo.persistencia.txt;

//Usado conforme exemplo Lorenzon de Generics e persistência Serializable

public interface SerializableTXT {
    String toSerializableTxt();
    void fromSerializableTxt(String linha);
}
