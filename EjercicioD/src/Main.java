import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readerQuiz();
        System.out.print("Codigo finalizado");
    }

    public static ArrayList<String> reader(){
        //creando el scanner
        ArrayList<String> tokens = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //leyendo los caracteres
        do{
            System.out.print("ingrese numero del hexagono\n");
            tokens.add(scanner.next());
            System.out.print("ingrese el caracter del hexagono\n");
            System.out.println(tokens);
            if(tokens.equals("exit")) {
                break;
            }
        } while (scanner.hasNext());

        return tokens;
    }

    public static void readerQuiz() {
        System.out.println(
                "Buenas, ¿como desea ingresar su input?\n"
                + "1) Ingresar datos por consola\n"
                + "2) Ingresar por archivo .txt\n"
        );

        // leyendo el dato
        String result;
        Scanner scanner = new Scanner(System.in);
        result = scanner.next();
        System.out.println(result);

        //validando el dato
        if (result.equals("1")) {
            var newtokens = reader();
            painter(newtokens);
        } else if (result.equals("2")){
            String a = readerFile.Input.readFile("text.txt");
            //validación para sacar los inputs
        } else {
            System.out.println("No hay opciones validas...");
        }
    }

    public static String painter(ArrayList<String> newtokens){
        String result = newtokens.get(0);
        return result;
    }
}


/*  COMENTARIOS
 * cuando se ingresa un txt, con vairos casos.
 * 00 mata el programa
 * split para partir la cadena
 *
 * List<String> inputSplitted = Arrays.stream(inputSize.split(" "))
            .filter(param -> param.length() > 0)
            .collect(Collectors.toList());
 * */