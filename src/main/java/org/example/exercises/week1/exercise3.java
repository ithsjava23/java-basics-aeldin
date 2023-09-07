package org.example.exercises.week1;

import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv in två tal.");

        int valueOne = scanner.nextInt();
        int valueTwo = scanner.nextInt();

        if(valueOne < 0)
            valueOne = valueOne * -1;

        if(valueTwo < 0)
            valueTwo = valueTwo * -1;


        if(valueOne == valueTwo)
        {
            int doubleValue = (valueOne + valueTwo) * 2;
            System.out.println("Dubbla värdet av talens summa är " + doubleValue);
        }
        else
        {
            int sum = valueOne + valueTwo;
            System.out.println("Talens summa är " + sum);
        }
    }
}
