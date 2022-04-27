package com.csci4810;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file;

        Scanner keyboard = new Scanner(System.in);
        String command = "";
        double sx,sy = 1;
        double cx,cy = 0;
        double angle;
        double[][] transformMatrix = new double[3][3];
        //Default value identity matrix for transformation matrix
        transformMatrix[0][0] = 1;
        transformMatrix[1][1] = 1;
        transformMatrix[2][2] = 1;

        CustomGraphic graphic = new CustomGraphic();

        //Initial File must be given in order to use program
        System.out.println("Please enter a file name that contains your data. \nMake sure the .txt file is" +
                " placed inside the DataFile folder.");
        file = keyboard.nextLine();
        graphic.inputLines(file);
        System.out.println("File data has been read.");

        while(!command.equals("0")) {
            System.out.println("COMMANDS:");
            System.out.println("1) Input File Lines");
            System.out.println("2) Apply a Transformation");
            System.out.println("3) Display Pixels");
            System.out.println("4) Output Lines to a New File");
            System.out.println("5) Basic Translation");
            System.out.println("6) Basic Scale Around Origin");
            System.out.println("7) Basic Rotate Around Origin");
            System.out.println("8) Scale With Given Center");
            System.out.println("9) Rotate with Given Center");
            System.out.println("0) Quit");
            command = keyboard.next();

            switch (command) {
                case "0":
                    System.exit(0);
                    break;
                case "q":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Enter a file name: ");
                    keyboard.nextLine();
                    file = keyboard.nextLine();
                    graphic.inputLines(file);
                    System.out.println("File data has been read.");
                    break;
                case "2":
                    graphic.applyTransformation(transformMatrix);
                    System.out.println("Transformation applied.");
                    break;
                case "3":
                    graphic.displayPixels();
                    break;
                case "4":
                    System.out.println("Enter a file name: ");
                    keyboard.nextLine();
                    file = keyboard.nextLine();
                    graphic.outputLines(file);
                    break;
                case "5":
                    System.out.println("Translate in x direction: ");
                    double tx = keyboard.nextDouble();
                    System.out.println("Translate in y direction: ");
                    double ty = keyboard.nextDouble();
                    transformMatrix = graphic.basicTranslate(tx,ty); //basic translate and save matrix
                    System.out.print("Would you like to apply this transformation? (y/n)");
                    command = keyboard.next();
                    if(command.equals("y")) {
                        graphic.applyTransformation(transformMatrix); //apply the transformation
                        System.out.println("Transformation applied.");
                    }
                    break;
                case "6":
                    System.out.println("Scale factor in x direction: ");
                    sx = keyboard.nextDouble();
                    System.out.println("Scale factor in y direction: ");
                    sy = keyboard.nextDouble();
                    transformMatrix = graphic.basicScale(sx,sy); //basic scale and save matrix
                    System.out.print("Would you like to apply this transformation? (y/n)");
                    command = keyboard.next();
                    if(command.equals("y")) {
                        graphic.applyTransformation(transformMatrix); //apply the transformation
                        System.out.println("Transformation applied.");
                    }
                    break;
                case "7":
                    System.out.println("Rotation Angle: ");
                    angle = keyboard.nextDouble();
                    transformMatrix = graphic.basicRotate(angle);
                    System.out.print("Would you like to apply this transformation? (y/n)");
                    command = keyboard.next();
                    if(command.equals("y")) {
                        graphic.applyTransformation(transformMatrix); //apply the transformation
                        System.out.println("Transformation applied.");
                    }
                    break;
                case "8":
                    System.out.println("Scale factor in x direction: ");
                    sx = keyboard.nextDouble();
                    System.out.println("Scale factor in y direction: ");
                    sy = keyboard.nextDouble();
                    System.out.println("X-coordinate of the center of scale: ");
                    cx = keyboard.nextDouble();
                    System.out.println("Y-coordinate of the center of scale: ");
                    cy = keyboard.nextDouble();
                    transformMatrix = graphic.scale(sx,sy,cx,cy); //basic scale and save matrix
                    System.out.print("Would you like to apply this transformation? (y/n)");
                    command = keyboard.next();
                    if(command.equals("y")) {
                        graphic.applyTransformation(transformMatrix); //apply the transformation
                        System.out.println("Transformation applied.");
                    }
                    break;
                case "9":
                    System.out.println("Rotation Angle: ");
                    angle = keyboard.nextDouble();
                    System.out.println("X-coordinate of the center of rotation: ");
                    cx = keyboard.nextDouble();
                    System.out.println("Y-coordinate of the center of rotation: ");
                    cy = keyboard.nextDouble();
                    transformMatrix = graphic.rotate(angle,cx,cy); //basic scale and save matrix
                    System.out.print("Would you like to apply this transformation? (y/n)");
                    command = keyboard.next();
                    if(command.equals("y")) {
                        graphic.applyTransformation(transformMatrix); //apply the transformation
                        System.out.println("Transformation applied.");
                    }
                    break;
                default:
                    System.out.println("Sorry Command Not Found.");
                    break;
            }
        }
        System.exit(0);
    }
}
