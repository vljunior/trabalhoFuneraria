package temadogrupo.modelo;

public class ConfiguracaoSingleton {
    
    private static ConfiguracaoSingleton unicaInstancia;    

    private ConfiguracaoSingleton() {         
    }

    public static ConfiguracaoSingleton getInstanciaSingleton(){
        if (unicaInstancia == null) {
            unicaInstancia = new ConfiguracaoSingleton();
        }
        return unicaInstancia;
    }   

}
