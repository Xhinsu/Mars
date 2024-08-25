package org.example;

import org.example.DATA.*;
import org.example.INPUT.InputParser;

import java.util.*;

import static org.example.DATA.Rover.*;
import static org.example.DATA.Rover.setLandingPosition;
import static org.example.INPUT.InputParser.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

Position position = new Position() ;
Rover rover = new Rover(position);
Plateau plateau = Plateau.getInstance();




plateau.setPlateauDimensions(inputPlateauDimensions());
setLandingPosition();

rover.start();
// int r = 0;
//
//        boolean test = r>0;
//        System.out.println(test);


    }
}