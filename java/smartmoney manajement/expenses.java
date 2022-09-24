package smart_money_app;

import java.util.Scanner;

/**
 *
 * @author rowzeal
 */
public class Expense {

    

    public static int getTotalExpenses() {
        Scanner input = new Scanner(System.in);
        String[] expenditureTitles = {"foods", "clothes", "college fees", "travelling", "miscellaneous"};
        Integer[] expenditureAmount = new Integer[expenditureTitles.length];

        for (int i = 0; i < expenditureTitles.length; i++) {
            System.out.print("How much do you spend in " + expenditureTitles[i] + "(Rs.): ");
            expenditureAmount[i] = input.nextInt();
            System.out.println();
        }
        
        int totalExpenses = 0;
        for (int i = 0; i < expenditureTitles.length; i++) {
            totalExpenses = totalExpenses + expenditureAmount[i];

        }
        return totalExpenses;
    }

}

