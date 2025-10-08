package temadogrupo.modelo;

import java.util.List;

import temadogrupo.persistencia.txt.ArquivoTextoRepositorio;
import temadogrupo.persistencia.txt.Repositorio;
import temadogrupo.persistencia.txt.SerializableTXT;
import temadogrupo.persistencia.txt.Servico;


//Esta classe é Singleton e Serializable, mas com uso de SerializableTXT e generics do exemplo Lorenzon Presistencia OO no MVN

public class ConfiguracaoSingleton implements SerializableTXT {

    private static ConfiguracaoSingleton instancia;

    private String opcao; //um atributo de configuração pra seguir de exemplo para os demais que surgirem

    private ConfiguracaoSingleton() {
        carregarConfiguracoes();
    }

    public static ConfiguracaoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoSingleton();
        }
        return instancia;
    }

    public String getOpcao() { 
        return opcao; 
    }
    
    public void setOpcao(String opcao) { 
        this.opcao = opcao; 
    }

    // Serialização
    @Override
    public String toSerializableTxt() {
        return opcao;
    }

    @Override
    public ConfiguracaoSingleton fromSerializableTxt(String linha) {
        
        ConfiguracaoSingleton c = getInstancia(); //Sempre atendendo o singleton
        c.opcao = linha;
        return c;
    }

    private void carregarConfiguracoes() {
        try {
            Repositorio<ConfiguracaoSingleton> repositorio =
                new ArquivoTextoRepositorio<ConfiguracaoSingleton>("config.txt", this);
            Servico<ConfiguracaoSingleton> servico = new Servico<ConfiguracaoSingleton>(repositorio);
            List<ConfiguracaoSingleton> lista = servico.carregar();
            if (!lista.isEmpty()) {
                this.opcao = lista.get(0).getOpcao();
            } else {
                this.opcao = "default"; // valor inicial
            }
        } catch (Exception e) {
            this.opcao = "default";
        }
    }

    public void salvarConfiguracoes() {
        try {
            Repositorio<ConfiguracaoSingleton> repositorio =
                new ArquivoTextoRepositorio<ConfiguracaoSingleton>("config.txt", this);
            Servico<ConfiguracaoSingleton> servico = new Servico<ConfiguracaoSingleton>(repositorio);
            servico.salvar(List.of(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}