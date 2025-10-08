package temadogrupo.modelo;

public class ConfiguracaoSingleton {
    
    private static ConfiguracaoSingleton unicaInstancia;    
        
    private ConfiguracaoSingleton() {         
    }

    public static Singleton getInstanciaSingleton(){
        if (unicaInstancia == null) {
            unicaInstancia = new Singleton();
        }
        return unicaInstancia;
    }   

}
