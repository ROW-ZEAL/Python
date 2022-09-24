package smart_money_app;

/**
 *
 * @author rowzeal
 */
public class Smart_money_app {

    public static void main(String[] args) {

        int totalIncomes = Income.getTotalIncomes();
        System.out.println("--------------------------------------------------");
        System.out.println("Your total income is Rs. " + totalIncomes);
        System.out.println("--------------------------------------------------");
        int totalExpenses = Expense.getTotalExpenses();
        System.out.println("--------------------------------------------------");
        System.out.println("Your total expense is Rs. " + totalIncomes);
        System.out.println("--------------------------------------------------");
        getFinancialStatus(totalIncomes, totalExpenses);
    }

    public static void getFinancialStatus(int income, int expense) {
        if (income > expense) {
            int saving = income - expense;
            System.out.println();
            System.out.println("====================================================");
            System.out.println("You have savings of Rs. " + saving);
            System.out.println("====================================================");

        } else if (income < expense) {
            int loss = expense - income;
            System.out.println();
            System.out.println("====================================================");
            System.out.println("You have loss of Rs. " + loss);
            System.out.println("====================================================");
        } else {
            System.out.println("====================================================");
            System.out.println("You are in balanced status.");
            System.out.println("====================================================");
        }
    }

}
