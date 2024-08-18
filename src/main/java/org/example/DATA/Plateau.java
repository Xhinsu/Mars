package org.example.DATA;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Plateau {

    private int[][] plateau ;
    private static Plateau instance;

    public Plateau(){
    }

    public static Plateau getInstance() {
        if(instance == null) instance = new Plateau();
        return instance;
    }

    public int[][] getPlateau() {
        return plateau;
    }


    public void setPlateauDimensions(String input){
        assert input != null;
        String[] dimension =input.split(" ");
        while(true){
//            try{
                if(input.length() <= 3){
                    this.plateau = new int[Integer.parseInt(dimension[0])][ Integer.parseInt(dimension[1])];
                    break;
                }
                else {System.out.println("invalid");};
//            }catch (Exception e) {
//                System.err.println("Error: " + e.getMessage() + ". Add int rows and column");
//            }
        }
    }

    @Override
    public String toString() {
        return "this is: " + Arrays.deepToString(plateau);
    }
}
