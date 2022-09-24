//headerfilemissing//

{
    String cont_or_exit;
    do {
        double ruppesRate_of_dollar = 126.49;
        double rupeesRate_of_euro = 131.97;
        System.out.print("Todays Rate is 1$ = 126.49 Rs.\n Todays Rate is 1E = 131.97 Rs\n");
        System.out.print("What do you want to exchange  do press \n 1.Dollar to Nepali \n 2.Nepali to Dollar \n 3.Euro to Nepali \n 4.Nepali to Euro\n");
        System.out.print("Enter 1 or 2 or 3 or 4 :");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.print("You are converting dollar to Rs.\n");
                System.out.println("How many dollar do you want to exchange");
                double dollar = input.nextDouble();
                System.out.println("=======================");
                System.out.println(dollar + " dollar  = " +  dollar * ruppesRate_of_dollar + " Rs.");
                System.out.println("=======================");
            }
            case 2 -> {
                System.out.print("You are converting Rs to dollar\n");
                System.out.println("How many Rs. do you want to exchange");
                double rupees = input.nextDouble();
                System.out.println("=======================");
                System.out.println(rupees + " Rs  = " +  Double.toString(rupees/ruppesRate_of_dollar) + " dollar");
                System.out.println("=======================");
            }
            case 3 -> {
                System.out.print("You are converting Euro to Rs.\n");
                System.out.println("How many Euro do you want to exchange");
                double Euro = input.nextDouble();
                System.out.println("=======================");
                System.out.println(Euro + " Euro  = " +  Euro * rupeesRate_of_euro + " Rs.");
                System.out.println("=======================");
            }
            case 4 -> {
                System.out.print("You are converting Rs to Euro\n");
                System.out.println("How many Euro do you want to exchange");
                double rupees = input.nextDouble();
                System.out.println("=======================");
                System.out.println(rupees + " Rs  = " +  Double.toString(rupees/rupeesRate_of_euro) + " euro");
                System.out.println("=======================");
            }
            
            default -> System.out.println("You did not enter 1 or 2");
        }
        System.out.println("Type cont for continue and exit for exit");
        input.nextLine();
        cont_or_exit = input.nextLine();

    } while (cont_or_exit.equals("cont"));
    System.out.println("Thank you for your exchange");
}
}

