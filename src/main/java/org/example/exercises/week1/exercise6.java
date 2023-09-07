package org.example.exercises.week1;

import java.util.Random;

public class exercise6 {
    public static void main(String[] args) {
     int[] randomNr = new int[10];
     int[] randomNrReversed = new int[10];
        Random random = new Random();

        for(int i = 0; i < randomNr.length; i++) {
            int a = random.nextInt();
            randomNr[i] = a;
        }
        for(int i = 0; i < randomNrReversed.length; i++){
            randomNrReversed[i] = randomNr[9-i];
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(randomNr[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(randomNrReversed[i] + ", ");
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                sum = randomNrReversed[i] + sum;
            }
        }
        System.out.println("\n" + "Sum of random number: " + sum);
        }

    }
