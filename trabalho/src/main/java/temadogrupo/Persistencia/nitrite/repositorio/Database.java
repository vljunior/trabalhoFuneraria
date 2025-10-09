package temadogrupo.persistencia.nitrite.repositorio;

import org.dizitart.no2.Nitrite;

public final class Database {

    private static Nitrite bancoDeDadosNitrite;

    private Database() {

    }

    public static synchronized Nitrite getDb() { //importante o synchronized
        if (bancoDeDadosNitrite == null || bancoDeDadosNitrite.isClosed()) {
            bancoDeDadosNitrite = Nitrite.builder()
                    .filePath("funeraria.db")
                    .openOrCreate("user", "password");            
        }
        return bancoDeDadosNitrite;
    }

    public static synchronized void fecharDb() {
        if (bancoDeDadosNitrite != null && !bancoDeDadosNitrite.isClosed()) {
            bancoDeDadosNitrite.close();
        }
    }
}