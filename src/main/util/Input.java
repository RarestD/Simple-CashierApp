package main.util;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(String info){
        System.out.print(info  + " : ");
        return scanner.nextLine();
    }

    public static String inputString(){
        return scanner.nextLine();
    }

    public static Integer inputInt(String info) {
        System.out.print(info + ": ");
        int result = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline
        return result;
    }

    public static Double inputDouble(String info) {
        System.out.print(info + ": ");
        double result = scanner.nextDouble();
        scanner.nextLine(); // consume the leftover newline
        return result;
    }

}
