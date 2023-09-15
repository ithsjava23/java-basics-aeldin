package org.example;


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class App {


    public static int[] enterPrices(Scanner scanner) {


        int[] prices = new int[24];


        for (int i = 0; i < 24; i++) {
            System.out.print("Timme " + i + "-" + (i + 1) + ": \n");
            prices[i] = scanner.nextInt();
        }
         scanner.nextLine();
        return prices;
    }

    public static void printMinMaxAverage(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = prices[0];
        int minHour = 0;
        int maxHour = 0;
        int total = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minHour = i;
            }
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
                maxHour = i;
            }
            total += prices[i];
        }

        double averagePrice = (double) total / prices.length;

        System.out.printf("Lägsta pris: %02d-%02d, %d öre/kWh\n" ,minHour, minHour + 1, minPrice );
        System.out.printf("Högsta pris: %02d-%02d, %d öre/kWh\n" ,maxHour, maxHour + 1, maxPrice);
        System.out.printf("Medelpris: %.2f öre/kWh\n", averagePrice);




    }

    public static void printSortedPrices(int[] prices){

        int[] sortedPrices = Arrays.copyOf(prices, prices.length);
        int[] sortedHours = new int[prices.length];


        for (int i = 0; i < prices.length; i++) {
            sortedHours[i] = i;
        }


        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = 0; j < prices.length - i - 1; j++) {
                if (sortedPrices[j] < sortedPrices[j + 1]) {

                    int tempPrice = sortedPrices[j];
                    sortedPrices[j] = sortedPrices[j + 1];
                    sortedPrices[j + 1] = tempPrice;

                    int tempHour = sortedHours[j];
                    sortedHours[j] = sortedHours[j + 1];
                    sortedHours[j + 1] = tempHour;
                }
            }
        }

        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%02d-%02d %d öre\n", sortedHours[i], sortedHours[i] + 1, sortedPrices[i]);
        }
    }

    public static void findBestChargingTime(int[] prices) {


        int bestTotalPrice = Integer.MAX_VALUE;
        int bestStartTime = -1;

        for (int i = 0; i <= prices.length - 4; i++) {
            int totalPrice = prices[i] + prices[i + 1] + prices[i + 2] + prices[i + 3];
            if (totalPrice < bestTotalPrice) {
                bestTotalPrice = totalPrice;
                bestStartTime = i;
            }
        }

        float averagePrice = (float) bestTotalPrice / 4;

        System.out.printf("Påbörja laddning klockan %d\n", bestStartTime);
        System.out.printf("Medelpris 4h: %.1f öre/kWh\n", averagePrice);
    }




    public static void main(String[] args) {
        Locale swedishLocale = Locale.of("sv", "SE");
        Locale.setDefault(swedishLocale);
        Scanner scanner = new Scanner(System.in);
        int choice;
        int[] prices = null;

    do {

        System.out.print("Elpriser\n");
        System.out.print("========\n");
        System.out.print("1. Inmatning\n");
        System.out.print("2. Min, Max och Medel\n");
        System.out.print("3. Sortera\n");
        System.out.print("4. Bästa Laddningstid (4h)\n");
        System.out.print("e. Avsluta\n");


        String input = scanner.next();

        if (input.equalsIgnoreCase("e"))
            break;

        try {
            choice= Integer.parseInt(input);

        switch (choice) {
            case 1 -> prices = enterPrices(scanner);
            case 2 -> printMinMaxAverage(prices);
            case 3 -> printSortedPrices(prices);
            case 4 -> findBestChargingTime(prices);
            default -> {

            }
            }
        } catch (NumberFormatException e) {

        }
    } while (true);



    }
}
