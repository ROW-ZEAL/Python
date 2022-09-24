{
    getOrder();
}

public static void getOrder() {

    int momo_price = 120;
    int chowmin_price = 100;
    int coffee_price = 50;
    System.out.println("Please chose a food you want to have \n");
    System.out.println(" 1. MOMO @ Rs. 120\n 2. CHOWMEIN @ Rs. 100\n 3. COFFEE @ Rs. 50 ");
    Scanner sc = new Scanner(System.in);
    System.out.print("what do you want to give consume sir : Separate by comma");
    String menu_item_choice = sc.nextLine();
    String[] menu_item_number_array = menu_item_choice.split(",");
    System.out.println("You have selected " + Integer.toString(menu_item_number_array.length) + " types of food items");

    int final_total_bill = 0;
    for (int i = 0; i < menu_item_number_array.length; i++) {
        switch (menu_item_number_array[i]) {
            case "1":
                System.out.print("You have selected to consume Momo.");
                System.out.print("How many plates momo do you want? ");
                int no_of_momo_plates_ordered = sc.nextInt();
                System.out.println("=======================");
                System.out.println("You have ordered " + no_of_momo_plates_ordered + " plates of momo and  your price is : " + momo_price * no_of_momo_plates_ordered);
                System.out.println("=======================");
                int total_charges_of_momo = no_of_momo_plates_ordered * momo_price;
                final_total_bill = final_total_bill + total_charges_of_momo;
                break;
            case "2":
                System.out.print("You have selected to consume Chowmein.");
                System.out.print("How many plates chowmein do you want? ");
                int no_of_chowmein_plates_ordered = sc.nextInt();
                System.out.println("=======================");
                System.out.println("You have ordered " + no_of_chowmein_plates_ordered + " plates of chowmein and  your price is : " + chowmin_price * no_of_chowmein_plates_ordered);
                System.out.println("=======================");
                int total_charges_of_chowmein = no_of_chowmein_plates_ordered * chowmin_price;
                final_total_bill = final_total_bill + total_charges_of_chowmein;
                break;

            case "3":
                System.out.print("You have selected to consume coffee. ");
                System.out.print("How many cups of coffee do you want? ");
                int no_of_coffee_cups_ordered = sc.nextInt();
                System.out.println("=======================");
                System.out.println("You have ordered " + no_of_coffee_cups_ordered + " cups of coffee and  your price is : " + coffee_price * no_of_coffee_cups_ordered);
                System.out.println("=======================");
                int total_charges_of_coffee = no_of_coffee_cups_ordered * coffee_price;
                final_total_bill = final_total_bill + total_charges_of_coffee;
                break;

            default:
                System.out.println("=======================");
                System.out.println("write correct number");

        }
    }

    System.out.println("=======================");
    System.out.println("Your total bill is Rs. " + Integer.toString(final_total_bill));
    System.out.println("=======================");

}


    


}
