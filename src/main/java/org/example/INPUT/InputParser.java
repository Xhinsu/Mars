package org.example.INPUT;

import org.example.DATA.CompassDirection;
import org.example.DATA.Instruction;
import org.example.DATA.PlateauSize;
import org.example.DATA.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    Position currentPosition;
//    CompassDirection currentCompassDirection;

    public InputParser(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Instruction> userInput() {

        Scanner scanner = new Scanner(System.in);
        List<Instruction> instructionsList = new ArrayList<>();
        while (true) {
            System.out.println("enter instructions: L, R or M");
            String tempInput = scanner.nextLine();
            if (tempInput.equals("L")) {
                instructionsList.add(Instruction.L);
            } else if (tempInput.equals("R")) {
                instructionsList.add(Instruction.R);
            } else if (tempInput.equals("M")) {
                instructionsList.add(Instruction.M);
            } else if (tempInput.equals("end")) {
                System.out.println("break path");
                break;
            } else {
                System.out.println("invalid path");
            }
        }
        System.out.println(instructionsList);
        return instructionsList;
    }


    public void changeInitialDirection() {
        if (currentPosition.getFacing() == null) {
            currentPosition.setFacing(CompassDirection.N);
        }
    }



    public PlateauSize setPlateauDimensions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plateau dimensions:");
        String[] dimensions = scanner.nextLine().split(" ");
        return new PlateauSize(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
    }





//        if(currentPosition.getFacing() == CompassDirection.N|| currentPosition.getFacing() ==CompassDirection.S){
//         changeDirection();
//
//
//            this.currentPosition =
//            System.out.println(this.currentPosition);
//        } else if (currentPosition.getFacing() == CompassDirection.W|| currentPosition.getFacing() ==CompassDirection.E) {
//
//
//        }
    }

