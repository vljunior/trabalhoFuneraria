package temadogrupo.modelo;

import temadogrupo.persistencia.nitrite.repositorio.ClienteRepositorioNitrite;
import temadogrupo.persistencia.nitrite.servico.ClienteServico;
import temadogrupo.persistencia.txt.*;
import temadogrupo.persistencia.nitrite.repositorio.Database;
import java.io.IOException;
import org.dizitart.no2.Nitrite;



//Esta classe é Singleton e Serializable, mas com uso de SerializableTXT e generics do exemplo Lorenzon Presistencia OO no MVN

public class ConfiguracaoSingleton implements SerializableTXT {

    private static ConfiguracaoSingleton instancia;
    private static Nitrite bancoDeDadosNitrite;    
    public static ClienteServico servicoCliente;

    private String nomeFuneraria = "Funerária"; 
    private int maximoLinhasLog = 100;

    public int getMaximoLinhasLog() {
        return maximoLinhasLog;
    }

    public void setMaximoLinhasLog(int maximoLinhasLog) {
        this.maximoLinhasLog = maximoLinhasLog;
    }

    private ConfiguracaoSingleton() {
        carregarConfiguracoes();   
        bancoDeDadosNitrite = Database.getDb();     
    }

    public void fecharDatabase(){
        Database.fecharDb();
    }

    public static ConfiguracaoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoSingleton();
        }
        return instancia;
    }

    public String getNomeFuneraria() { 
        return nomeFuneraria; 
    }
    
    public void setNomeFuneraria(String nome) { 
        this.nomeFuneraria = nome; 
    }

    // Serialização
    @Override
    public String toSerializableTxt() {
        return getNomeFuneraria() + ";" +
               getMaximoLinhasLog() + ";";
    }

    @Override
    public void fromSerializableTxt(String linha) {      
        
        String[] partes = linha.split(";");
        setNomeFuneraria(partes[0]);
        setMaximoLinhasLog(Integer.parseInt(partes[1]));
        //int idade = Integer.parseInt(partes[1]);        
        
    }

    private void carregarConfiguracoes() {
        
        try {            
            
            new ArquivoTxtConfiguracoes("config.txt").carregar(this);    
            
        } catch (IOException e) {
            setNomeFuneraria("Sem Nome");
            setMaximoLinhasLog(100);
        }

    }

    public void salvarConfiguracoes() {
        try {
            new ArquivoTxtConfiguracoes("config.txt").salvar(this);                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ClienteServico getServicoCliente() {
       

        if (servicoCliente == null) {            
            servicoCliente = new ClienteServico(new ClienteRepositorioNitrite(Database.getDb()));            
        }
        
        return servicoCliente;
    }   

}

    