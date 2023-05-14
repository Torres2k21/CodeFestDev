import java.lang.invoke.StringConcatFactory;
import java.util.*;
public class Main {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        //read file
        String input = Input.readFile("test.txt");
        var inputSplit = input.split("\n");
        //Variables
        int largestNumber, smallestNumber, result;
        String ascendingNumber, descendingNumber;
        //exercise development
        for (int i = 0; i < inputSplit.length; i++) {
            //variables
            String cadena = inputSplit[i];
            //validating input
            if(validateLength(cadena) && validateNumber(cadena) && validateTwoDifferentNumbers(cadena)){
                do {
                    //get ascendingNumber and descendingNumber
                    ascendingNumber = generateNumberUpward(cadena);
                    descendingNumber = generateNumberDownward(cadena);
                    //get descendingNumber and smallestNumber
                    var largestAndSmallestNumber=  getlargestNumberAndSmallestNumber(ascendingNumber,descendingNumber);
                    largestNumber = Integer.parseInt(largestAndSmallestNumber.get("largest"));
                    smallestNumber = Integer.parseInt(largestAndSmallestNumber.get("smallest"));
                    //subtract number
                    result = subtraction(largestNumber,smallestNumber);
                    System.out.println(largestNumber+"-"+smallestNumber+"="+result);
                    cadena = ""+result;
                    if (cadena.equals("6174")) break;
                }while (true);
                System.out.println("\n ****** \n");
            }else{
                System.out.println("\nLa cadena ingresada: "+cadena+" no cumple con lo requerido para ser analizada");
            }
        }
    }
    private static  boolean  validateLength(String cadena){
        int cadenaLength = cadena.length();
        boolean isCorrect = cadenaLength == 4? true : false;
        return isCorrect;
    }
    private static  boolean  validateNumber(String cadena){
        try {
            int number = Integer.parseInt(cadena);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    private static  boolean  validateTwoDifferentNumbers(String cadena){
        Set<Character> caracteresUnicos = new HashSet<Character>();
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            caracteresUnicos.add(caracter);
            if (caracteresUnicos.size() > 1) {
                return true;
            }
        }
        return false;
    }
    private static String generateNumberUpward(String cadena){
        char[] digits = cadena.toCharArray();
        Arrays.sort(digits);
        String numberUpward = new String(digits);
        return numberUpward;
    }
    private static String generateNumberDownward(String cadena){
        char[] digits = cadena.toCharArray();
        Arrays.sort(digits);
        String numberUpward="";
        for (int i = digits.length -1; i >= 0; i--){
            numberUpward = numberUpward+digits[i];
        }
        return numberUpward;
    }

    private static Map<String, String> getlargestNumberAndSmallestNumber(String ascendingNumber, String descendingNumber){
        Map<String, String> diccionarioNumber = new HashMap<String, String>();
        int number1 = Integer.parseInt(ascendingNumber);
        int number2 = Integer.parseInt(descendingNumber);
        if (number1>number2) {
            diccionarioNumber.put("largest",""+number1);
            diccionarioNumber.put("smallest",""+number2);
        }
        else{
            diccionarioNumber.put("largest",""+number2);
            diccionarioNumber.put("smallest",""+number1);
        }
        return diccionarioNumber;
    }
    private static  int subtraction(int largestNumber, int smallestNumber){
        return largestNumber - smallestNumber;
    }
}