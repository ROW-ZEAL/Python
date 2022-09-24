package parking_management;

import java.util.Scanner;

public class Parking_management {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = sc.nextLine();
        System.out.print("Enter your number : ");
        long number = sc.nextLong();
        System.out.print("Enter your parking_id : ");
        int parking_id = sc.nextInt();
        
        System.out.println("List of packages available");
        System.out.println("S.N package Type    Price    Student");
        System.out.println(" 1  Full day        Rs 400   Rs 200");
        System.out.println(" 2  One night       Rs 500   Rs 400");
        System.out.println(" 3  Office hours    Rs 200   Rs 100");
        System.out.println(" 4  Full week       Rs 2000  Rs 1000");
        
        System.out.println("Enter 1 or 2 or 3 or 4 ");
        int packages = sc.nextInt();

        System.out.println("Are you a student? Enter yes or no");
        sc.nextLine();
        String input = sc.nextLine();

        if(input.equals("yes")){
            display_total_amount_for_student(name, number, parking_id, packages);
        } else if (input.equals("no")){
            display_total_amount_for_non_student(name, number, parking_id, packages);
        }else{
            System.out.println("We have treated you as non student");
            display_total_amount_for_non_student(name, number, parking_id, packages);
        }
    }

    public static void display_total_amount_for_student(String name, long number, int parking_id, int packages) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your collage name");
        String collegeName = sc.nextLine();
        System.out.println();
        System.out.println("==========================================");
        System.out.println("             Bill                 ");
        System.out.println("Name:                        " + name);
        System.out.println("Mobile number:               " + number);
        System.out.println("Parking id:                  " + parking_id);
        System.out.println("Student:                      Y      ");
        System.out.println("Colllege Name:               " + collegeName);

        switch (packages) {
            case 1:
                System.out.println("Service name:                Full Day");
                System.out.println("Fee:                         200");
                break;
            case 2:
                System.out.println("Service name:                One night");
                System.out.println("Fee:                         400");
                break;
            case 3:
                System.out.println("Service name:                Office hour");
                System.out.println("Fee:                         100");
                break;
            case 4:
                System.out.println("Service name:                full week");
                System.out.println("Fee:                         1000");
                break;
            default:
                System.out.println("You have not choosen exact package");
        }
        
        System.out.println("==========================================");

    }

    public static void display_total_amount_for_non_student(String name, long number, int parking_id, int packages) {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("             Bill                 ");
        System.out.println("Name:                        " + name);
        System.out.println("Mobile number:               " + number);
        System.out.println("Parking id:                  " + parking_id);
        System.out.println("Student:                      N      ");
        switch (packages) {
            case 1:
                System.out.println("service name:                full Day");
                System.out.println("fee:                         400");
                break;
            case 2:
                System.out.println("service name:                One night");
                System.out.println("fee:                         500");
                break;
            case 3:
                System.out.println("service name:                Office hour");
                System.out.println("fee:                         200");
                break;
            case 4:
                System.out.println("service name:                full week");
                System.out.println("fee:                         2000");
                break;
            default:
                System.out.println("You have not choosen exact package");
            System.out.println("==========================================");

        }
        
    }
}
