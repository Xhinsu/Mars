package org.example.INPUT;

import org.example.DATA.Instruction;
import org.example.DATA.Plateau;
import org.example.DATA.Position;
import org.example.DATA.Rover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @Test
    public void firstTest(){
        boolean value = true;
        assertTrue(value);
    }

    @Test
    @DisplayName("Testing parseUserInput methods")
    public void parseUserInputEmpty(){
        InputParser inputParser = new InputParser(Position.getInstance());
        String expected = "[]";
        String input = " ";
        String actualResult = inputParser.parseInputToInstruction(input).toString();
        assertEquals(expected, actualResult );

    }
    @Test
    public void parseUserInputLowCases(){
        InputParser inputParser = new InputParser(Position.getInstance());
        String expected = "[]";
        String input = "lmr";
        String actualResult = inputParser.parseInputToInstruction(input).toString();
        assertEquals(expected, actualResult );

    }

    @Test
    public void parseUserInputPartialValid(){
        InputParser inputParser = new InputParser(Position.getInstance());
        String expected = "[]";
        String input = InputParser.parseInstructionString("LmrM");
        String actualResult = inputParser.parseInputToInstruction(input).toString();
        assertEquals(expected, actualResult );
    }
    @Test
    public void parseUserInputLongValid(){
        InputParser inputParser = new InputParser(Position.getInstance());
        String expected = "[L, M, R, M, M, M, M]";
        String input = InputParser.parseInstructionString("LMRMMMM");
        String actualResult = inputParser.parseInputToInstruction(input).toString();
        assertEquals(expected, actualResult );
    }
    @Test
    public void parseUserInputSmallValid(){
        InputParser inputParser = new InputParser(Position.getInstance());
        String expected = "[L]";
        String input = InputParser.parseInstructionString("L");
        String actualResult = inputParser.parseInputToInstruction(input).toString();
        assertEquals(expected, actualResult );
    }
    @Test
    public void parseInputToInstructionCheckingValidInput(){
        InputParser inputParser = new InputParser(Position.getInstance());
        int expected = 3;
        String input ="LLM";

        int actualResult = inputParser.parseInputToInstruction(input).size();
        assertEquals(expected, actualResult );
    }
    @Test
    public void parseInputToInstructionCheckingInValidInput(){
        InputParser inputParser = new InputParser(Position.getInstance());
        int expected = 0;
        String input ="LLm";

        int actualResult = inputParser.parseInputToInstruction(input).size();
        assertEquals(expected, actualResult );
    }

    @Test
    public void parseInputToInstructionCheckingEmptyInput(){
        InputParser inputParser = new InputParser(Position.getInstance());
        int expected = 0;
        String input ="";

        int actualResult = inputParser.parseInputToInstruction(input).size();
        assertEquals(expected, actualResult );
    }
    @Test
    public void roverSetLandingEmptyString(){
        String expected = "";
        String input ="";

        String actualResult = InputParser.parseLandingInput(input);
        assertEquals(expected, actualResult );
    }

    @Test
    public void roverSetLandingInvalidInput(){
        String expected = "";
        String input ="l";

        String actualResult = InputParser.parseLandingInput(input);
        assertEquals(expected, actualResult );
    }
    @Test
    public void roverSetLandingInvalidInputs(){
        String expected = "";
        String input ="lADSF";

        String actualResult = InputParser.parseLandingInput(input);
        assertEquals(expected, actualResult );
    }
    @Test
    public void roverSetLandingOutOfBound(){
        String expected = "";
        String input ="6 6 S";

        String actualResult = InputParser.parseLandingInput(input);
        assertEquals(expected, actualResult );
    }

    @Test
    public void roverSetLandingValidInput(){
        String expected = "1 1 N";
        String input ="1 1 N";

        String actualResult = InputParser.parseLandingInput(input);
        assertEquals(expected, actualResult );
    }
    @Test
    public void roverSetLandingValidInputII(){
        String expected = "3 4 W";
        String input ="3 4 W";

        String actualResult = InputParser.parseLandingInput(input);
        assertEquals(expected, actualResult );
    }

    @Test
    @DisplayName("Testing setPlateauMethods")
    public void plateauNullInput(){
        Plateau plateau =new Plateau();
        String expected = null;

        assertNull(plateau.getPlateau());
    }

   @Test
    public void plateauInvalidInput(){
        Plateau plateau =new Plateau();
        String input ="asdfa";
        plateau.setPlateauDimensions(input);

        assertNull(plateau.getPlateau());
    }

    @Test
    public void plateauValidInputWithoutSpaces(){
        Plateau plateau =new Plateau();
        String input ="55";
        plateau.setPlateauDimensions(input);
       assertNull(plateau.getPlateau());
    }

    @Test
    @DisplayName("Tested plateau rows/column of void method")
    public void plateauValidInput(){
        Plateau plateau =new Plateau();
        String input ="5 5";
        plateau.setPlateauDimensions(input);
        int[][] dimension = plateau.getPlateau();
        int rowLength = dimension.length;
        int columnLength = dimension[0].length;
        String actual = Integer.toString(rowLength)+ Integer.toString(columnLength);
        String expected = "55";
        assertEquals(actual,expected);
    }











}