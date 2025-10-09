package temadogrupo.modelo.Valor;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Endereco {

    private final String cep;
    private final String rua;
    private final String numero;
    private final String cidade;
    private final String estado;

    @JsonCreator
    public Endereco (
            @JsonProperty("cep") String cep,
            @JsonProperty("rua") String rua,
            @JsonProperty("numero") String numero,
            @JsonProperty("cidade") String cidade,
            @JsonProperty("estado") String estado) throws IllegalArgumentException {

        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("Rua não pode ser nula ou vazia");
        }
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número não pode ser nulo ou vazio");
        }
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia");
        }
        if (estado == null || estado.isBlank()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia");
        }
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("Cep não pode ser nulo ou vazio");
        }

        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getRua() { 
        return rua; 
    }    

    public String getNumero() { 
        return numero; 
    }    

    public String getCidade() { 
        return cidade; 
    }

    public String getCep() {
        return cep;
    }
    
    public String getEstado(){
        return estado;
    }
    

    // equals e hashCode para comparar por valores (Value Object)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return rua.equals(endereco.rua) &&
               numero.equals(endereco.numero) &&
               cidade.equals(endereco.cidade); //o resto fazer
    }    

    @Override
    public int hashCode() {
        return Objects.hash (rua, numero, cidade);
    }

    @Override
    public String toString() {
        return rua + ", " + numero + ". Cep: " + cep + ", " + cidade + "-" + estado;
    }
}
