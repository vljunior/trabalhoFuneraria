package temadogrupo.modelo;

import temadogrupo.persistencia.txt.*;
import temadogrupo.utilitarios.Video;

import java.io.IOException;



//Esta classe é Singleton e Serializable, mas com uso de SerializableTXT e generics do exemplo Lorenzon Presistencia OO no MVN

public class ConfiguracaoSingleton implements SerializableTXT {

    private static ConfiguracaoSingleton instancia;

    private String opcao = "Algo"; //um atributo de configuração pra seguir de exemplo para os demais que surgirem

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
        return getOpcao() + ";";
    }

    @Override
    public void fromSerializableTxt(String linha) {      
        
        String[] partes = linha.split(";");
        setOpcao(partes[0]);
        //int idade = Integer.parseInt(partes[1]);        
        
    }

    private void carregarConfiguracoes() {
        
        try {            
            
            new ArquivoTxtConfiguracoes("config.txt").carregar(this);    
            
        } catch (IOException e) {
            setOpcao("padrao");
        }
    }

    public void salvarConfiguracoes() {
        try {
            new ArquivoTxtConfiguracoes("config.txt").salvar(this);                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}