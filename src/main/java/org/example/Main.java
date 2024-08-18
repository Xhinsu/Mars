package org.example;

import org.example.DATA.*;
import org.example.INPUT.InputParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.example.INPUT.InputParser.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    InputParser inputParser = new InputParser(Position.getInstance());
    Position position = Position.getInstance();
    Rover rover = new Rover(position);
    Plateau plateau = new Plateau();

//   plateau.setPlateauDimensions(null);

        String input ="5 7";
//        int[][] expected = new int[5][5];

//        plateau.setPlateauDimensions(input);
//        System.out.println(Arrays.deepToString(plateau.getPlateau()));

        plateau.setPlateauDimensions(input);
        int[][] expected = plateau.getPlateau();
//        System.out.println(Arrays.deepToString(expected));
        System.out.println(expected.length);
        System.out.println(expected[0].length);



//        inputParser.parseInputToInstruction(InputParser.getUserInput());

//        System.out.println(Instruction.L);
//    Position position = new Position(1,2, CompassDirection.S);
//    InputParser inputParser = new InputParser(Position.getInstance());
////    System.out.println(position.toString());
//    inputParser.move();










    }
}