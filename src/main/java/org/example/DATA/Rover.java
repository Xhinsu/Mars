package org.example.DATA;

import org.example.INPUT.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rover {
    Position currentPosition;


    public Rover(Position position){
        this.currentPosition = position;
    }


    public static void setLandingPosition(){
//        Scanner scanner = new Scanner(System.in);
        String regex = "^[012345] [012345] [NEWS]";
        while (true){
            String landingInstruction = InputParser.parseLandingInput(InputParser.getLandingInput());
            if(landingInstruction.matches(regex)){
                String[] landingInstructionArray = landingInstruction.split(" ");
                Position.getInstance().setX(Integer.parseInt(landingInstructionArray[0]));
                Position.getInstance().setY(Integer.parseInt(landingInstructionArray[1]));
                Position.getInstance().setFacing(CompassDirection.valueOf(landingInstructionArray[2]));
//                System.out.println(landingInstruction);
                break;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }

    public void changeDirection(Instruction instruction) {
        ArrayList<CompassDirection> compassDirectionList = new ArrayList<>(List.of(CompassDirection.N, CompassDirection.E, CompassDirection.S, CompassDirection.W));
        int currentCompassDirectionIndex = compassDirectionList.indexOf(currentPosition.getFacing()); //current index

        if(currentCompassDirectionIndex == 0 && instruction.equals(Instruction.L)){
            Position.getInstance().setFacing(compassDirectionList.get(currentCompassDirectionIndex+3));
        }
        else if(currentCompassDirectionIndex == 3 && instruction.equals(Instruction.R)){
            Position.getInstance().setFacing(compassDirectionList.getFirst());
        }
        else if(instruction.equals(Instruction.R)){
            Position.getInstance().setFacing(compassDirectionList.get(currentCompassDirectionIndex+1));
        }
        else if(instruction.equals(Instruction.L)){
            {
                Position.getInstance().setFacing(compassDirectionList.get(currentCompassDirectionIndex-1));}
        }
    }


    public void move() {
        var instructions = InputParser.parseInputToInstruction(InputParser.getInputInstruction());

        for (int i = 0; i < instructions.size(); i++) {

            if (instructions.get(i).equals(Instruction.L) || instructions.get(i).equals(Instruction.R)) {
                changeDirection(instructions.get(i));
            } else if (instructions.get(i).equals(Instruction.M)) {
                if (currentPosition.getFacing() == CompassDirection.N) {
                    if(currentPosition.getY()<6){currentPosition.setY(currentPosition.getY() + 1);}
                    else{System.out.println("rover cant move beyond: " + currentPosition.getY());}
                } else if (currentPosition.getFacing() == CompassDirection.E) {
                    if(currentPosition.getY()<6){currentPosition.setX(currentPosition.getX() + 1);}
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
        }}

        @Override
        public String toString() {
            return String.format("Current position is x:%d y:%d and %s ", this.currentPosition.getX(), this.currentPosition.getY(), this.currentPosition.getFacing());
        }
    }
