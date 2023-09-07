package org.example.exercises.week1;

import java.util.Scanner;

public class exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the current weekday.");

        String day = scanner.nextLine();


        int dayNumber = switch (day) {
            case "Monday", "monday", "Mon", "mon" -> 1;
            case "Tuesday", "tuesday", "Tues", "tues" -> 2;
            case "Wednesday", "wednesday", "Wed", "wed" -> 3;
            case "Thursday", "thursday", "Thur", "thur" -> 4;
            case "Friday", "friday", "Fri", "fri" -> 5;
            case "Saturday", "saturday", "Sat", "sat" -> 6;
            case "Sunday", "sunday", "Sun", "sun" -> 7;
            default-> 0;


        };
        System.out.println("Weekday number: " + dayNumber);


    }
}
