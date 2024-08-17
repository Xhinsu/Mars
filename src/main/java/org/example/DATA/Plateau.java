package org.example.DATA;

import java.util.Arrays;
import java.util.Scanner;

public class Plateau {

    private int[][] plateau ;

    public Plateau(){
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }


    public int[][] setPlateauDimensions(String input){
        if(input == null) return null;
        String[] dimension =input.split(" ");

//        if(dimensions.length<2){
//            this.plateau = new int[Integer.parseInt(dimensions[0])][ Integer.parseInt(dimensions[1])];
//            return this.plateau;
//        }else {
//            System.out.println("Invalid input");
//        }
        System.out.println(Arrays.deepToString(plateau));
        return this.plateau;
    }

    @Override
    public String toString() {
        return "this is: " + Arrays.deepToString(plateau);
    }
}
