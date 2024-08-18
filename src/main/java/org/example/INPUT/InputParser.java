package org.example.INPUT;

import org.example.DATA.CompassDirection;
import org.example.DATA.Instruction;
import org.example.DATA.Plateau;
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

    //Setting initial landing coordinates!
    public static String getLandingInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter landing cordinates: ");
        return scanner.nextLine();
    }
    //parsing strings and filtering invalid
    public static String parseLandingInput(String input) {
        String regex = "^[012345] [012345] [NEWS]";
        String result = "";

            if (input.matches(regex)) {
                result+=input;
            }else{
            System.out.println("Invalid landing coordinates");}

        System.out.println(result);
        return result;
    }
//Getting user input for movement/changing instruction
    public static String getInputInstruction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter instructions: ");
        String userInput = scanner.nextLine();
        scanner.close();
        return userInput;
    }
//parse user input and filter to get valid string
    public static String parseInstructionString (String input){
            String userInputRegex = "[LRM][LRM]{1,15}";
            String result = "";

            if (input.matches(userInputRegex)) {
                result += input;
                System.out.println(input);
            } else {
                System.out.println("invalid input");
            }
            return result;
        }
//convert valid user input into instructions
    public static List<Instruction> parseInputToInstruction(String input) {

        List<Instruction> instructionsList = new ArrayList<>();
        String[] tempInput = parseInstructionString(input).split("");
        for (int i = 0; i < tempInput.length; i++) {
                    if (tempInput[i].equals("L")) {
                        instructionsList.add(Instruction.L);
                    } else if (tempInput[i].equals("R")) {
                        instructionsList.add(Instruction.R);
                    } else if (tempInput[i].equals("M")) {
                        instructionsList.add(Instruction.M);
                    }
                }
            System.out.println(instructionsList);
            return instructionsList;
    }
    public static String inputPlateauDimensions(){
        String result ="";
        Scanner scanner = new Scanner(System.in);
        String regex = "^[0-9] [0-9]";
        while (true) {

            System.out.println("Enter plateau dimensions:");
            String input = scanner.nextLine();
            if (input.matches(regex)) {
                result = input;
                System.out.println(result);
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        return result;

    }
}

