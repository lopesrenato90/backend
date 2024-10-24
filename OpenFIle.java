import javax.swing.*;
import java.awt.*;
import java.io.*;



public class OpenFIle {
    public static void abrirArquivo() {
        try {
            JFileChooser chooser = new JFileChooser();

            chooser.setDialogTitle("Selecione o arquivo que deseja abrir");
            chooser.setApproveButtonText("Abrir arquivo");
            int returnVal1 = chooser.showOpenDialog(null);
            String fileFullPath = "";
            if(returnVal1 == JFileChooser.APPROVE_OPTION) {
                fileFullPath = chooser.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("Que pena!");
            }
        
            try {
                File file = new File(fileFullPath);
                //Pode-se usar o operador ! (exclamação) para negar o resultado da expressão lógica (que esteja à sua direita)
                if(!Desktop.isDesktopSupported()) {
                    System.err.println("not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if(file.exists()) {
                    desktop.open(file);
                }

            }catch(Exception e) {
                e.printStackTrace();
            }

            System.out.println("Arquivo aberto com sucesso!"); 
            } catch (Exception e) {
                System.out.print("Não foi possível abrir o arquivo");
            }
        
        }
    }
