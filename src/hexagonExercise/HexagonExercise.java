package hexagonExercise;

import utils.Console;
import utils.FileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.DataFormatException;

public class HexagonExercise {
    /*
        Ctrl + Alt + /: Comentar
        Implementa un programa que, dado un entero "n" y un carácter "c", dibuje el hexágono regular
        de "n" caracteres "c" de lado.
    */
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    private ArrayList<HexagonData> hexagonDataList = new ArrayList<>();
    private final String INPUT_FILENAME = "input_hexagon.txt", OUTPUT_FILENAME = "output_hexagon.txt";
    //</editor-fold>
    public HexagonExercise() throws Exception {
        final String source = read();
        if (source == null)
            return;
        fillHexagonDataList(source);
    }
    //<editor-fold defaultstate="collapsed" desc="I/O">
    private String read() throws Exception {
        try {
            return FileHandler.readFile(INPUT_FILENAME);
        }
        catch (Exception ex) {
            throw new Exception("Ocurrió un error al leer el archivo de lectura " + INPUT_FILENAME);
        }
    }
    private void write(String content) throws Exception {
        try {
            FileHandler.writeFile(OUTPUT_FILENAME, content);
            Console.Notify("¡Escrito exitosamente! Revisa el archivo " + OUTPUT_FILENAME);
        }
        catch (Exception ex) {
            throw new Exception("Ocurrió un error al escribir en el archivo de salida " + OUTPUT_FILENAME);
        }
    }
    //</editor-fold>
    private void fillHexagonDataList(String source) throws Exception {
        final String[] lines = source.split("\n");
        int errorLineIdx = 0;
        try {
            for (int idx = 0; idx < lines.length; idx++) {
                final String line = lines[idx];
                final String[] parts = analizeLine(line);
                errorLineIdx = idx;
                final int side = HexagonData.parseToSide(parts[0]);
                final char character = HexagonData.parseToCharacter(parts[1]);
                final HexagonData hexagonData = new HexagonData(side, character);
                if (hexagonData.getSide() < 3)
                    continue;
                hexagonDataList.add(hexagonData);
            }
        }
        catch (Exception ex) {
            throw new DataFormatException("Error en línea " + errorLineIdx + ": " + ex.getMessage());
        }
    }
    private String[] analizeLine(String line) throws Exception {
        line = line.trim();
        // Obteniendo las partes sin espacios
        String[] parts = Arrays.stream(line.split(" "))
                .map(String::trim)
                .filter(part -> part.length() > 0)
                .toArray(String[]::new);
        if (parts.length != 2)
            throw new DataFormatException("Solo {lados} {caracter}");
        return parts;
    }
    public void renderHexagonList() throws Exception {
        final StringBuilder output = new StringBuilder();
        for (HexagonData hexagonData : hexagonDataList)
            renderHexagon(hexagonData, output);
        write(output.toString());
    }
    private void renderHexagon(HexagonData hexagonData, StringBuilder output) {
        final int height = (hexagonData.getSide() * 2) - 1;
        boolean toForward = true;
        for (int row = 1; row <= height; row++) {
            final int spaces = Math.abs(hexagonData.getSide() - row);
            final int charactersFactor = toForward ? row - 1 : height - row;
            final int characters = hexagonData.getSide() + (charactersFactor)*2;
            renderHexagonRow(
                    hexagonData,
                    spaces,
                    characters,
                    output
            );
            if (spaces == 0)
                toForward = false;
        }
    }
    private void renderHexagonRow(
            final HexagonData hexagonData,
            final int spaces,
            final int characters,
            StringBuilder output
    ) {
        for (int column = 1; column <= spaces * 2 + characters; column++) {
            // Renderizando espacios
            if (column <= spaces || column > spaces + characters) {
                output.append(" ");
                continue;
            }
            // Renderizando caracteres
            output.append(hexagonData.getCharacter());
        }
        output.append("\n");
    }
}
