package smart_money_app;

/**
 *
 * @author rowzeal
 */
import java.util.Scanner;

public class Income {

    public static int getTotalIncomes() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how much money you earn in this month(Rs.): ");
        int monthlyIncome = input.nextInt();
        System.out.println();
        System.out.print("Enter the profit made from investment(Rs.): ");
        int investmentIncome = input.nextInt();
        System.out.println();
        System.out.print("Enter the amount earned from rent(Rs.):  ");
        int rentIncome = input.nextInt();
        System.out.println();
        return monthlyIncome + investmentIncome + rentIncome;
        
    }

}
