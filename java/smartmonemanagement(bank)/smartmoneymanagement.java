
package bank;
import static bank.Deposit.bankBalance;
import java.util.Scanner;
public class Bank {
    static String email;
    static String pw;
    static boolean condition;
     static Scanner sc = new Scanner(System.in);
    
    public static void login(){
        System.out.println("WELCOME TO codeX BANK");
        
       do{
        System.out.println("Pls provide details to create a bank account");
        System.out.println("");
        System.out.println("Enter email address");
        email = sc.nextLine();
        System.out.println("create a strong password");
        pw = sc.nextLine();
           
       }while(email.isEmpty() && pw.isEmpty());
        System.out.println("Your bank acc has been created!");
        System.out.println("");
        System.out.println("Enter your login details");
        
        
         do{
            
        System.out.println("Enter your email: ");
        String em = sc.nextLine();
        System.out.println("Enter your password: ");
        String pwd  = sc.nextLine();
         condition = !em.equals(email)|| !pwd.equals(pw);
         if (condition ){
             System.out.println("");
             System.out.println("Either your password or email address was wrong pls try again");
         }else{
            int idx = em.indexOf("@");
            String name = em.substring(0,idx);
             System.out.println("");
            System.out.println("Welcome Back! " + name );
             
         }
        }
        while (condition);
    }
    public static void action(){
        Deposit dpst = new Deposit();
        Withdraw wdrw = new Withdraw();
        System.out.println("Press the corresponding numbers for the following actions: \n1.view bank balance\n2.Deposit\n3.Withdraw\n4.Bank Transfer\n5.exit");
         int ans = sc.nextInt();
         switch (ans){
             case 1:
                 dpst.viewBankBalance();
                  System.out.println("Bank Balance :"+bankBalance);
                    if (bankBalance<5000){
                    System.out.println("LOL you broke AF boii");
        }
                    action();
                    
                 break;
             case 2:
                 dpst.calcDepositAmt();
                 break;
             case 3:
                 wdrw.calcWithdrawAmt();
                 break;
             case 4:
                 wdrw.bankTransfer();
             case 5:
                 break;
             
             default:
                 System.out.println("pls choose a corresponding number");
         }
    }
    
    public static void main(String[] args) {
        
        login();
        action();
         
         
         
      
         
         
    }
   
    
}

