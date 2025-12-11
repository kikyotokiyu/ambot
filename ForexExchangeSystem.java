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
        
     
        System.out.printf("%-9s | %-8s %-8s %-8s %-8s %-8s %-8s %-8s%n", 
                "Currency", "Nov1", "Nov2", "Nov3", "Nov4", "Nov5", "Peak", "Lowest");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < currencies.length; i++) {
            
         
            double peak = rates[i][0];
            double lowest = rates[i][0];

            for (double rate : rates[i]) {
                if (rate > peak) peak = rate;
                if (rate < lowest) lowest = rate;
            }
            System.out.printf("%-9s | ", currencies[i]);
            for (int day = 0; day < 5; day++) {
                System.out.printf("%-8.2f ", rates[i][day]);
            }

           
            System.out.printf("%-8.2f %-8.2f%n", peak, lowest);
        }
        System.out.println("-------------------------------------------------------------------------");

       
        System.out.println("\n=== DAILY CHANGES (Comparison From Previous Day) ===");
        System.out.println("(+ increase / - decrease / no change for same value)\n");

        for (int i = 0; i < currencies.length; i++) {
            System.out.println("Currency: " + currencies[i]);
            
          
            for (int day = 0; day < 4; day++) {
                double currentDay = rates[i][day];
                double nextDay = rates[i][day + 1];
                double diff = nextDay - currentDay;

                System.out.print(dates[day] + " -> " + dates[day + 1] + ": ");

              
                if (Math.abs(diff) < 0.0001) { 
                    
                    System.out.println("No Change");
                } else if (diff > 0) {
                   
                    System.out.printf("+ %.2f%n", diff);
                } else {
                  
                    System.out.printf("%.2f%n", diff);
                }
            }
            System.out.println();
        }

        sc.close();
    }
}