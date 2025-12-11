import java.util.Scanner;

public class ForexExchangeSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] currencies = {"USD", "EUR", "JPY", "GBP", "AUD"};
        String[] dates = {"Nov 1", "Nov 2", "Nov 3", "Nov 4", "Nov 5"};

        double[][] rates = new double[5][5];

        for (int i = 0; i < currencies.length; i++) {
            System.out.println("Currency: " + currencies[i]);
            for (int day = 0; day < 5; day++) {
                System.out.print("Rate on " + dates[day] + ": ");
                rates[i][day] = sc.nextDouble();
            }
        }

        System.out.println("\n=================== FOREX SUMMARY (Nov 1 - Nov 5) ===================");


        System.out.printf("%-7s | ", "Date");
        for (String currency : currencies) {
            System.out.printf("%-8s ", currency);
        }
        System.out.println("Peak    Lowest");
        System.out.println("-----------------------------------------------------------------------");


        for (int day = 0; day < 5; day++) {

            double peak = rates[0][day];
            double lowest = rates[0][day];

            for (int i = 1; i < currencies.length; i++) {
                if (rates[i][day] > peak) peak = rates[i][day];
                if (rates[i][day] < lowest) lowest = rates[i][day];
            }

            System.out.printf("%-7s | ", dates[day]);
            for (int i = 0; i < currencies.length; i++) {
                System.out.printf("%-8.2f ", rates[i][day]);
            }

            System.out.printf("%-8.2f %-8.2f%n", peak, lowest);
        }

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("\n=== DAILY CHANGES PER DATE (Movement Across Currencies) ===\n");

        for (int day = 0; day < 4; day++) {
            System.out.println(dates[day] + " → " + dates[day + 1]);

            for (int i = 0; i < currencies.length; i++) {
                double diff = rates[i][day + 1] - rates[i][day];

                System.out.print("  " + currencies[i] + ": ");

                if (Math.abs(diff) < 0.0001) {
                    System.out.println("No Change");
                } else if (diff > 0) {
                    System.out.printf("+%.2f%n", diff);
                } else {
                    System.out.printf("%.2f%n", diff);
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
