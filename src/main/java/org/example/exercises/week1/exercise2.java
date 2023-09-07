package org.example.exercises.week1;

import java.util.Scanner;

public class exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv in 2 två tal.");

        int valueOne = scanner.nextInt();
        int valueTwo = scanner.nextInt();

        float average = (float) (valueOne + valueTwo) / 2;

        System.out.println("Medelvärdet av " + valueOne + " och " + valueTwo + " är " + average);

    }

}
