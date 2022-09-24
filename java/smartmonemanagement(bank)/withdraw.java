
package bank;
import java.util.Scanner;

public class Withdraw {
    static Scanner sc = new Scanner(System.in);
    static int withdrawAmt;
    static String bankName;
    static boolean condition;
    static int amt;
    
    public static void calcWithdrawAmt(){
        
        Deposit dpst = new Deposit();
        System.out.println("Your bank balance is:\n"+ dpst.viewBankBalance()+"\n How much do you want to withdraw?");
        
        withdrawAmt = sc.nextInt();
        sc.nextLine();
        if(withdrawAmt<=Deposit.bankBalance){
            System.out.println("\n You withdrew "+withdrawAmt+"\n");
        }
        else{
            System.out.println("You cannot withdraw more than your Bank balance");
        }
            
        
        Bank bnk = new Bank();
        bnk.action();
        
    }
    public static void bankTransfer(){
        Deposit dpst = new Deposit();
        String[] banks = {"NIC Asia","Global IME","CodeX bank" };
        System.out.println("You can only transfer to these banks");
        for (String banknames: banks){
            System.out.println(banknames);
        }
        do{
        System.out.println("Which bank do you want to transfer to?");
        bankName = sc.nextLine();
        condition = bankName.equals(banks[0]) || bankName.equals(banks[1]) || bankName.equals(banks[2]);
        }while(!condition);
        
           System.out.println("Enter email address of the user you want to transfer to:");
            String email = sc.nextLine();
            System.out.println("Enter amount :");
             amt = sc.nextInt();
             sc.nextLine();
             if(amt<=Deposit.bankBalance){
                  int idx = email.indexOf("@");
            String name = email.substring(0,idx);
            System.out.println("YOu have successfully transfered Rs "+amt+" to "+name);
             }else{
                 System.out.println("You cannot transfer more than your bank balance");
             }
           
        Bank bnk = new Bank();
         bnk.action();
            
        }
        
    
}
