package labyrinthExercise;

import utils.FileHandler;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LabyrinthExercise {
    public LabyrinthExercise() {
        /*String input = FileHandler.readFile("input_magos.txt");
        if (input == null) {
            error("Archivo no encontrado");
            return;
        }
        String[] inputInLines = input.split(("\n"));
        String inputSize = inputInLines[0];
        Dimension size = getDimensions(inputSize);
        if (size == null)
            return;
        List<String> labyrinth = getLabyrinth(inputInLines);
        int startPointInSouth = getStartCellInLabyrinth(labyrinth, size);
        if (startPointInSouth == -1) {
            error("No existe punto de partida en el sur :/");
            return;
        }
        if (!checkWallsToTheEdge(labyrinth, size)) {
            error("Los muros deben estar alrededor");
            return;
        }
        String result = getResult(labyrinth, startPointInSouth);
        log("Resultado: " + result);*/
    }
    private static List<String> getLabyrinth(String[] inputInLines) {
        List<String> labyrinth = new ArrayList<>();
        for (int i = 0; i < inputInLines.length; i++) {
            if (i == 0) continue;
            labyrinth.add(inputInLines[i]);
        }
        return labyrinth;
    }
    private static void log(String msg) {
        System.out.print(msg);
    }
    private static void error(String msg) {
        log("Error: " + msg);
    }
    private static Dimension getDimensions(String inputSize) {
        List<String> inputSplitted = Arrays.stream(inputSize.split(" "))
                .filter(param -> param.length() > 0)
                .collect(Collectors.toList());
        if (inputSplitted.size() != 2) {
            error("Solo ancho y alto respectivamente");
            return null;
        }
        try {
            int width = Integer.parseInt(inputSplitted.get(0));
            int height = Integer.parseInt(inputSplitted.get(1));
            Dimension size = new Dimension(width, height);
            if (checkSize(size))
                return size;
            error("El ancho y alto deben ser >= 3 y <= 300");
            return null;
        }
        catch (Exception ex) {
            error("Ambos deben ser enteros");
            return null;
        }
    }
    private static boolean checkSize(Dimension size) {
        return size.width >= 3 && size.width <= 300 && size.height >= 3 && size.height <= 300;
    }
    private static int getStartCellInLabyrinth(List<String> labyrinth, Dimension size) {
        for (int column = 0; column < size.width - 1; column++) {
            String cell = getCellFromLabyrinth(labyrinth, size.height - 1, column);
            if (cell.equals(Cell.TRANSITABLE))
                return column;
        }
        return -1;
    }
    private static String getCellFromLabyrinth(List<String> labyrinth, int row, int column) {
        return String.valueOf(labyrinth.get(row).charAt(column));
    }
    private static boolean checkWallsToTheEdge(List<String> labyrinth, Dimension size) {
        for (int row = 0; row < size.height; row++) {
            for (int column = 0; column < size.width; column++) {
                /*if (row == 0 || row == size.height) {
                    System.out.println(labyrinthExercise.Cell.WALL);
                    String cell = getCellFromLabyrinth(labyrinth, size.height - 1, column);
                    if (row == size.height - 1 &&
                        column > 0 &&
                        column < size.width - 1 &&
                        cell.equals(labyrinthExercise.Cell.TRANSITABLE))
                        continue;
                    if (!cell.equals(labyrinthExercise.Cell.WALL))
                        return false;
                }
                else {
                    System.out.print(" ");
                }*/
                if (row == 0 || row == size.height - 1 || column == 0 || column == size.width -1) {
                    String cell = getCellFromLabyrinth(labyrinth, row, column);
                    if (row == size.height - 1 && column > 0 && column < size.width - 1) {
                        if (cell.equals(Cell.TRANSITABLE))
                            continue;
                    }
                    if (!cell.equals(Cell.WALL))
                        return false;
                }
            }
        }
        return true;
    }
    private static String getResult(List<String> labyrinth, int startPointInSouth) {
        int movementsRightHand = getMovementsRightHand(labyrinth, startPointInSouth);
        return "";
    }
    private static int getMovementsRightHand(List<String> labyrinth, int startPointInSouth) {
        int movements = 0;
        Point position = new Point(startPointInSouth, 0);
        do {
            if (getCellFromLabyrinth(labyrinth, position.y, position.x).equals(Cell.TROPHY))
                break;
            if (getCellFromLabyrinth(labyrinth, position.y, position.x + 1).equals(Cell.TRANSITABLE)) {
                position.x++;
                movements++;
                continue;
            }
            break;
        } while (true);
        /*
        10 3
        ##########
        #.......T#
        #.########
        * */
        return movements;
    }
}
