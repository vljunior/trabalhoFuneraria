package temadogrupo.modelo.Valor;

public class Cpf {
    private final String numero; // sempre armazenado só com dígitos

    public Cpf(String numero) {
        if (numero == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }

        String apenasDigitos = numero.replaceAll("[^0-9]", "");

        if (apenasDigitos.length() != 11 || !validarCpf(apenasDigitos)) {
            throw new IllegalArgumentException("CPF inválido: " + numero);
        }

        this.numero = apenasDigitos;
    }

    public String getNumero() {
        return numero;
    }

    public String getFormatado() {
        return numero.substring(0, 3) + "." +
               numero.substring(3, 6) + "." +
               numero.substring(6, 9) + "-" +
               numero.substring(9);
    }

    @Override
    public String toString() {
        return getFormatado();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cpf)) return false;
        Cpf outro = (Cpf) o;
        return numero.equals(outro.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }

    // 🔹 Algoritmo oficial de validação do CPF
    private boolean validarCpf(String cpf) {
        // elimina CPFs com todos dígitos iguais
        if (cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int resto = 11 - (soma % 11);
            int digito1 = (resto == 10 || resto == 11) ? 0 : resto;

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            resto = 11 - (soma % 11);
            int digito2 = (resto == 10 || resto == 11) ? 0 : resto;

            return digito1 == (cpf.charAt(9) - '0') &&
                   digito2 == (cpf.charAt(10) - '0');
        } catch (Exception e) {
            return false;
        }
    }
}