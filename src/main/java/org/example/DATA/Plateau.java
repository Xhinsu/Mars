package org.example.DATA;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Plateau {

    private int[][] plateau ;

    public Plateau(){
    }

    public int[][] getPlateau() {
        return plateau;
    }


    public void setPlateauDimensions(String input){
        assert input != null;
        String[] dimension =input.split(" ");
        try{
            if(input.length() <= 3){
                this.plateau = new int[Integer.parseInt(dimension[0])][ Integer.parseInt(dimension[1])];
            }else {
                System.out.println("Invalid input");
            }
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage() + ". Add rows and column");
        }
    }

    @Override
    public String toString() {
        return "this is: " + Arrays.deepToString(plateau);
    }
}
