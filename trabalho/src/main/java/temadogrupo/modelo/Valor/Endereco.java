package temadogrupo.modelo.Valor;

public class Endereco {

    private final String cep;
    private final String rua;
    private final String numero;
    private final String cidade;

    public Endereco(String cep, String rua, String numero, String cidade) throws IllegalArgumentException {

        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("Rua não pode ser nula ou vazia");
        }
        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número não pode ser nulo ou vazio");
        }
        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("Cidade não pode ser nula ou vazia");
        }
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("Cep não pode ser nulo ou vazio");
        }

        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
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

    // equals e hashCode para comparar por valores (Value Object)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return rua.equals(endereco.rua) &&
               numero.equals(endereco.numero) &&
               cidade.equals(endereco.cidade);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash (rua, numero, cidade);
    }

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + cidade;
    }*/
}
