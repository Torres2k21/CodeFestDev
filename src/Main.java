import hexagonExercise.HexagonExercise;
import utils.Console;

public class Main {
    public static void main(String[] args) {
        problem1();
    }
    public static void problem1() {
        try {
            HexagonExercise hexagonExercise = new HexagonExercise();
            hexagonExercise.renderHexagonList();
        }
        catch (Exception ex) {
            Console.Notify(ex.getMessage());
        }
    }
}