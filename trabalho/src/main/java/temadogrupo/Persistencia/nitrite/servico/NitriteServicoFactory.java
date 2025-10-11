package temadogrupo.persistencia.nitrite.servico;
import org.dizitart.no2.Nitrite;

import temadogrupo.persistencia.nitrite.repositorio.Database;
import temadogrupo.persistencia.nitrite.repositorio.ClienteRepositorioNitrite;
import temadogrupo.persistencia.nitrite.repositorio.FalecidoRepositorioNitrite;


public final class NitriteServicoFactory {

    public static <S> S criarServico(Class<S> tipoServico, Nitrite db) {
    
        if (tipoServico.equals(ClienteServico.class)) {            
            return (S) new ClienteServico(new ClienteRepositorioNitrite(Database.getDb()));
        }

        if (tipoServico.equals(FalecidoServico.class)) {
            return (S) new FalecidoServico (new FalecidoRepositorioNitrite(Database.getDb()));
        }

        throw new IllegalArgumentException("Serviço não suportado: " + tipoServico.getSimpleName());
    }
    
}