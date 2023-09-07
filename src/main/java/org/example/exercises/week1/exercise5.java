package org.example.exercises.week1;

public class exercise5 {
    public static void main(String[] args) {
        if(args.length != 3) {
            System.out.println("Add exactly three arguments. Program shutting down...");
        }

        int [] numbers = new int[3];
        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (Exception e) {
                System.out.println("You have to state a number. Answer is 0");
            }
            if(numbers[i] < 0) {
                System.out.println("You have to state a positive number. Answer is 0");
            }
        }
        int max = numbers[0];
        for (int i = 1; i < 3; i++) {
            if (numbers[i] > max)
                max = numbers[i];
        }
        System.out.println(max);


    }
}
