package controller;

import model.*;
import view.*;
import java.io.*;
import java.util.*;

public class InterfaceController extends InterfaceView {
    public static final String localViewImgFolder = System.getProperty("user.dir") 
        + "\\" 
        + "src"
        + "\\" 
        + "view"
        + "\\" 
        + "img";
    public static String imgPadrao;

    private static final Random random = new Random();

    public static void verificarApagarImagensInuteis() {
        final File folder = new File(localViewImgFolder);
        ArrayList<String> strImagens = listFilesForFolder(folder);
        InterfaceModel.validarImagens(strImagens);
    }

    public static ArrayList<String> listFilesForFolder(final File folder) {
        ArrayList<String> strFiles = new ArrayList<String>();
        if (folder.exists() && folder.isDirectory()) {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry != null) {
                    if (fileEntry.isDirectory()) {
                        strFiles.addAll(listFilesForFolder(fileEntry));
                    } else {
                        strFiles.add(fileEntry.getName());
                        System.out.println(fileEntry.getName());
                    }
                }
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório válido.");
        }
        return strFiles;
    }

    public static String gerarNomeArquivoAleatorio(int n) {
        // Gerar um número aleatório
        int randomNumber = random.nextInt();
        return String.format("file-%d-%d", n, randomNumber);
    }

    public static void main(String[] args) {
        System.out.println(gerarNomeArquivoAleatorio(3));
    }
}
