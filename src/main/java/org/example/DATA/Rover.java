package org.example.DATA;

import org.example.INPUT.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rover {
    static Position currentPosition;


    public Rover(Position position){
        currentPosition = position;
    }


    public static void setLandingPosition(){
//        Scanner scanner = new Scanner(System.in);
        String regex = "^[012345] [012345] [NEWS]";
        while (true){
            String landingInstruction = InputParser.parseLandingInput(InputParser.getLandingInput());
            if(landingInstruction.matches(regex)){
                String[] landingInstructionArray = landingInstruction.split(" ");
                currentPosition.setX(Integer.parseInt(landingInstructionArray[0]));
                currentPosition.setY(Integer.parseInt(landingInstructionArray[1]));
                currentPosition.setFacing(CompassDirection.valueOf(landingInstructionArray[2]));
                break;
            }
            else {
                System.out.println("Invalid input. Add 2 digit below 6 and 1 cardinal direction. i. 1 2 N");
            }
        }
    }

    public void changeDirection(Instruction instruction) {
        ArrayList<CompassDirection> compassDirectionList = new ArrayList<>(List.of(CompassDirection.N, CompassDirection.E, CompassDirection.S, CompassDirection.W));
        int currentCompassDirectionIndex = compassDirectionList.indexOf(currentPosition.getFacing()); //current index
        switch(instruction){
            case Instruction.L :
                currentPosition.setFacing(currentCompassDirectionIndex >0 ? compassDirectionList.get(currentCompassDirectionIndex-1): compassDirectionList.get(currentCompassDirectionIndex+3));
                break;
            case Instruction.R:
                currentPosition.setFacing(currentCompassDirectionIndex < 2 ? compassDirectionList.get(currentCompassDirectionIndex+1):compassDirectionList.get(currentCompassDirectionIndex-1));
                break;
        }
    }


    public void move() {
        var instructions = InputParser.parseInputToInstruction(InputParser.getInputInstruction());
        Plateau plateau =  Plateau.getInstance();
        int[][] dimension = plateau.getPlateau();
        int row = dimension.length;
        int column = dimension[0].length;
        for (int i = 0; i < instructions.size(); i++) {

            if (instructions.get(i).equals(Instruction.L) || instructions.get(i).equals(Instruction.R)) {
                changeDirection(instructions.get(i));
            } else if (instructions.get(i).equals(Instruction.M)) {
                if (currentPosition.getFacing() == CompassDirection.N) {
                    if(currentPosition.getY()<column){currentPosition.setY(currentPosition.getY() + 1);}
                    else{System.out.println("rover cant move beyond: " + currentPosition.getY());}
                } else if (currentPosition.getFacing() == CompassDirection.E) {
                    if(currentPosition.getY()<column){currentPosition.setX(currentPosition.getX() + 1);}
                    else{System.out.println("rover cant move beyond: " + currentPosition.getX());}
                }
                else if(currentPosition.getFacing()==CompassDirection.W){
                    if(currentPosition.getX()>0){currentPosition.setX(currentPosition.getX()-1);}
                    else{System.out.println("rover cant move below: "+currentPosition.getX());}}
                else if(currentPosition.getFacing()==CompassDirection.S){
                   if(currentPosition.getY()>0){currentPosition.setY(currentPosition.getY()-1);}
                   else{
                       System.out.println("rover cant move below: "+ currentPosition.getY());
                    }}
            }
        }
        System.out.println(currentPosition);
        }

        @Override
        public String toString() {
            return String.format("Current position is x:%d y:%d and %s ", currentPosition.getX(), currentPosition.getY(), currentPosition.getFacing());
        }
    }
