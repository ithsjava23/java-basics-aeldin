package org.example;


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class App {


    public static int[] enterPrices() {
        Scanner scanner = new Scanner(System.in);

        int[] prices = new int[24];

        System.out.print("\nAnge elpriser för dygnets alla timmar i öre per kWh");

        for (int i = 0; i < 24; i++) {
            System.out.print("\nTimme " + i + "-" + (i + 1) + ": ");
            prices[i] = scanner.nextInt();
        }

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

        System.out.print("\nLägsta pris: " + minHour + "-" + (minHour + 1) + ", " + minPrice + " öre/kWh");
        System.out.print("\nHögsta pris: " + maxHour + "-" + (maxHour + 1) + ", " + maxPrice + " öre/kWh");
        System.out.print("\nMedelpris: " + averagePrice + " öre/kWh\n");




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
            System.out.print("\n" + sortedHours[i] + "-" + (sortedHours[i] + 1) + ": " + sortedPrices[i] + " öre/kWh");
        }
    }

    public static void findBestChargingTime(int[] prices) {
        if (prices == null || prices.length < 4) {
            System.out.print("\nDet finns inte tillräckligt med data för att hitta de billigaste timmarna.");
            return;
        }

        int bestTotalPrice = Integer.MAX_VALUE;
        int bestStartTime = -1;

        for (int i = 0; i <= prices.length - 4; i++) {
            int totalPrice = prices[i] + prices[i + 1] + prices[i + 2] + prices[i + 3];
            if (totalPrice < bestTotalPrice) {
                bestTotalPrice = totalPrice;
                bestStartTime = i;
            }
        }

        int averagePrice = bestTotalPrice / 4;

        System.out.print("\nPåbörja laddning klockan: " + bestStartTime + ":00");
        System.out.print("\nMedelpris 4h: " + averagePrice);
    }




    public static void main(String[] args) {
        Locale swedishLocale = Locale.of("sv", "SE");
        Locale.setDefault(swedishLocale);
        Scanner scanner = new Scanner(System.in);
        int choice;
        int[] prices = null;

    do {

        System.out.print("\nElpriser");
        System.out.print("\n========");
        System.out.print("\n1. Inmatning");
        System.out.print("\n2. Min, Max och Medel");
        System.out.print("\n3. Sortera");
        System.out.print("\n4. Bästa Laddningstid (4h)");
        System.out.print("\ne. Avsluta\n");


        String input = scanner.next();

        if (input.equalsIgnoreCase("e"))
            break;

        try {
            choice= Integer.parseInt(input);

        switch (choice) {
            case 1 -> prices = enterPrices();
            case 2 -> printMinMaxAverage(prices);
            case 3 -> printSortedPrices(prices);
            case 4 -> findBestChargingTime(prices);
            default -> System.out.print("\nOgiltigt val.");
            }
        } catch (NumberFormatException e) {
            System.out.print("\nOgiltig inmatning.");
        }
    } while (true);

        System.out.print("\nProgrammet avslutas...");

    }
}
