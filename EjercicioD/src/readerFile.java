import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class readerFile {
    public class Input {
        public static String readFile(String filePath) {
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
                System.out.println(e.getMessage());
                return null;
            }
            return content.toString();
        }
    }
}
