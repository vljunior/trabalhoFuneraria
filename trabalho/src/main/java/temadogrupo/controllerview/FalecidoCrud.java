package temadogrupo.controllerview;

import java.time.LocalDate;
import java.util.List;
import temadogrupo.modelo.Falecido;
import temadogrupo.utilitarios.*;
import temadogrupo.persistencia.nitrite.servico.FalecidoServico;

public class FalecidoCrud {
  
    public static Falecido criarFalecido(FalecidoServico servico) {

        Video.limparTela();
        Video.cabecalho ("Cadastrar falecido!");        
        Video.mensagem("Informe os dados!");              

        String nome         = Teclado.readString("Nome:");
        int idade           = Teclado.readInt("Idade:");
        String documento    = Teclado.readString("Número de documento de identificação:");        
        String tipoDoc      = Teclado.readString("Tipo de documento:");
        LocalDate dataObito = Teclado.readDate("Digite a data de óbito");
        String causaMorte   = Teclado.readString("Causa morte:");
        String localObito   = Teclado.readString("Local do óbito:");
        String certidao     = Teclado.readString("Certidão:");
        
        //Demais dados conforme classe

        Falecido novo;        

        try {                    
            novo = new Falecido (nome, dataObito, causaMorte, localObito, idade, 
                                    certidao, documento, tipoDoc);
            if (novo == null) {
                throw new Exception(); //Se não deu erro, mas voltou nulo, forço o erro
            }
            servico.cadastrar(novo);
            Video.pausa();

        } catch (Exception e) {                
                Video.mensagemErro("Não foi possível concluir o cadastro: " + e.getMessage());
                Video.pausa();
                return null;                    
        }       

        return novo;
        
    }         

    public static void listarFalecidos(FalecidoServico servico){
        
        List<Falecido> falecidos = servico.listar();                                                
        //Guardian clause, Fail first
        if (falecidos == null) {
            Video.mensagemAlerta("Não há clientes cadastrados");
            Video.pausa();
            //Early break/return                                                   
            return;
        }                                                

        //happy path
        Video.cabecalho("Todos os clientes cadastrados:");
        for (Falecido falecido : falecidos) {
                System.out.println(falecido);
        }    
                
        Video.pausa();                                                
    }

}