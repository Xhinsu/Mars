package org.example;

import org.example.DATA.*;
import org.example.INPUT.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    InputParser inputParser = new InputParser(Position.getInstance());
    Position position = Position.getInstance();
//    PlateauSize plateauSize= inputParser.setPlateauDimensions();
    Rover rover = new Rover(position);
    rover.setLandingPosition();
    List<Instruction> instructions = inputParser.userInput();
    rover.move(instructions);


    System.out.println(rover);








//        System.out.println(Instruction.L);
//    Position position = new Position(1,2, CompassDirection.S);
//    InputParser inputParser = new InputParser(Position.getInstance());
////    System.out.println(position.toString());
//    inputParser.move();










    }
}