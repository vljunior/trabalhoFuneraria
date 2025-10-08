import temadogrupo.modelo.Falecido;
import temadogrupo.modelo.TipoPessoa;

/*Facotry*/

public class pessoaFactoryCriar {

    public Pessoa criarPessoa(TipoPessoa tipo, String cpf, String nome, Endereco endereco) {

        switch (tipo) {
            
            case CLIENTE -> {
                return new Cliente(cpf, nome, endereco, "contato-padrao", "parentesco-padrao");
            }
            
            case FALECIDO -> {
                return new Falecido(cpf, nome, endereco, java.time.LocalDate.now(), "local não informado");
            }

            default:
                throw new IllegalArgumentException("Tipo de pessoa inválido");
        }
    }
}
