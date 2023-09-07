package org.example.exercises.week1;

import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = scanner.nextLine();

        char[] letters = name.toCharArray();

        for (int i = 0; i < letters.length; i++) {

            letters[0] = Character.toUpperCase(letters[0]);

            if (letters[i] == ' ') {
                letters[i + 1] = Character.toUpperCase(letters[i + 1]);
            }
        }

        name = String.valueOf(letters);
        System.out.println("Hej " + name + ".");
    }
}
