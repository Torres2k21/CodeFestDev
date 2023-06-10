package hexagonExercise;

import java.util.zip.DataFormatException;

public class HexagonData {
    //<editor-fold defaultstate="collapsed" desc="Attributes">
    private int side;
    private char character;
    //</editor-fold>
    public HexagonData(int side, char character) throws Exception {
        this.side = side;
        this.character = character;
    }
    //<editor-fold defaultstate="collapsed" desc="Methods">
    public int getSide() {
        return side;
    }
    public char getCharacter() {
        return character;
    }
    public static int parseToSide(String value) throws Exception {
        try {
            return Integer.parseInt(value);
        }
        catch (Exception err) {
            throw new DataFormatException("El lado es inválido: '" + value + "'");
        }
    }
    public static char parseToCharacter(String value) throws Exception {
        if (value.length() > 1)
            throw new DataFormatException("El caracter es inválido: '" + value + "'");
        return value.charAt(0);
    }
    //</editor-fold>
}
