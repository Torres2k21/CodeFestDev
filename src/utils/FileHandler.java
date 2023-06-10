package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public static String readFile(String filePath) throws Exception {
        StringBuilder content = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new Exception("¡Oh! Ocurrió un error al leer el archivo :/");
        }
        return content.toString();
    }
    public static void writeFile(String pathFile, String content) throws Exception {
        try {
            FileWriter myWriter = new FileWriter(pathFile);
            myWriter.write(content);
            myWriter.close();
        } catch (IOException e) {
            throw new Exception("¡Oh! Ocurrió un error al escribir el archivo :/");
        }
    }
}
