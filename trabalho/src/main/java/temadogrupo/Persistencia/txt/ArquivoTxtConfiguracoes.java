package temadogrupo.persistencia.txt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import temadogrupo.utilitarios.Video;

public class ArquivoTxtConfiguracoes<T extends SerializableTXT> {
    private final String arquivo;

    public ArquivoTxtConfiguracoes(String arquivo) {
        this.arquivo = arquivo;
    }

    // Salva um único objeto em uma linha
    public void salvar(T obj) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.println(obj.toSerializableTxt());
        }
    }

    // Carrega um único objeto a partir da primeira linha
    public void carregar(T obj) throws IOException {

        File f = new File(arquivo);        

        if (!f.exists() || f.length() == 0) return;

        Scanner sc = new Scanner(f); 

        if (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
            
            if (!linha.isBlank()) {
                obj.fromSerializableTxt(linha);
            }
        }
    }
}