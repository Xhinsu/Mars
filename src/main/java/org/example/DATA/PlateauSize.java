package org.example.DATA;

import java.util.Arrays;

public class PlateauSize {

    public int[][] plateau ;

    public PlateauSize(int x, int y) {
        this.plateau = new int[x][y];
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }
    @Override
    public String toString() {
        return "this is: " + Arrays.deepToString(plateau);
    }
}
