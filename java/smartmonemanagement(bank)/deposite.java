
package bank;
import java.util.Scanner;
public class Deposit {
    static int depositAmt;
    
    static int bankBalance;
    
    public static void calcDepositAmt(){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("How much money do you want to deposit?");
        depositAmt = sc.nextInt();
         sc.nextLine();
        System.out.println("you have deposited "+ depositAmt+" to your bank acc.  ");
        bankBalance = bankBalance+depositAmt;
        Bank bnk = new Bank();
         bnk.action();
        
        }
    
    public static int viewBankBalance(){
       Withdraw wdrw = new Withdraw();
       bankBalance = bankBalance -wdrw.withdrawAmt - wdrw.amt;
       
       
        return bankBalance;
    }
    
    
            
}
