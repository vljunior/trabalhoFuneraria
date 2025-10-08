package temadogrupo.persistencia.txt;

//Usado conforme exemplo Lorenzon de Generics e persistência Serializable

public interface SerializableTXT {
    String toSerializableTxt();
    SerializableTXT fromSerializableTxt(String linha);
}
