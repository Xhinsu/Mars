package org.example.DATA;

import org.example.INPUT.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rover {
     static Position currentPosition;


    public Rover(Position position) {
        currentPosition = position;
    }


    public static void setLandingPosition() {
        String regex = "^[012345] [012345] [NEWS]";
        while (true) {
            String landingInstruction = InputParser.parseLandingInput(InputParser.getLandingInput());
            if (landingInstruction.matches(regex)) {
                String[] landingInstructionArray = landingInstruction.split(" ");
                currentPosition.setX(Integer.parseInt(landingInstructionArray[0]));
                currentPosition.setY(Integer.parseInt(landingInstructionArray[1]));
                currentPosition.setFacing(CompassDirection.valueOf(landingInstructionArray[2]));
                break;
            } else {
                System.out.println("Invalid input. Add 2 digit below 6 and 1 cardinal direction. i. 1 2 N");
            }
        }
    }

    //change direction
    public void changeDirection(Instruction instruction) {
        ArrayList<CompassDirection> compassDirectionList = new ArrayList<>(List.of(CompassDirection.N, CompassDirection.E, CompassDirection.S, CompassDirection.W));
        int currentCompassDirectionIndex = compassDirectionList.indexOf(currentPosition.getFacing()); //current index
        switch (instruction) {
            case Instruction.L:
                currentPosition.setFacing(currentCompassDirectionIndex > 0 ? compassDirectionList.get(currentCompassDirectionIndex - 1) : compassDirectionList.get(currentCompassDirectionIndex + 3));
                break;
            case Instruction.R:
                currentPosition.setFacing(currentCompassDirectionIndex < 2 ? compassDirectionList.get(currentCompassDirectionIndex + 1) : compassDirectionList.get(currentCompassDirectionIndex - 1));
                break;
        }
    }

    //Chyeck out of bound
    public static boolean[] isNotOutOfBound(){
        boolean[] result ;
        Plateau plateau = Plateau.getInstance();
        int[][] dimension = plateau.getPlateau();
        int plateauRow = dimension.length;
        int plateauColumn = dimension[0].length;
        boolean outOfBoundX = currentPosition.getX() < plateauRow && currentPosition.getX() >= 0;
        boolean outOfBoundY = currentPosition.getY() < plateauColumn && currentPosition.getY() >=0;
        return result= new boolean[]{outOfBoundX, outOfBoundY};

    }

    public void move(Instruction instruction) {

            switch (currentPosition.getFacing()){
                case CompassDirection.N:
                    if(isNotOutOfBound()[1]) currentPosition.setY(currentPosition.getY() + 1);
                break;
                case CompassDirection.S:
                    if(isNotOutOfBound()[1]) currentPosition.setY(currentPosition.getY() - 1);
                    break;
                case CompassDirection.E:
                    if(isNotOutOfBound()[0])currentPosition.setX(currentPosition.getX() + 1 );
                    break;
                case CompassDirection.W:
                    if(isNotOutOfBound()[0])currentPosition.setX(currentPosition.getX() - 1 );
                    break;
            }

            System.out.println(currentPosition);

            }




    public void start() {
        var instructions = InputParser.parseInputToInstruction(InputParser.getInputInstruction());
        for (Instruction instruction : instructions) {
            switch (instruction) {
                case Instruction.L:
                    changeDirection(Instruction.L);
                    break;
                case Instruction.R:
                    changeDirection(Instruction.R);
                    break;
                case Instruction.M:
                    move(Instruction.M);
            }
        }
        System.out.println(currentPosition);
    }

        @Override
        public String toString () {
            return String.format("Current position is x:%d y:%d and %s ", currentPosition.getX(), currentPosition.getY(), currentPosition.getFacing());
        }
    }
