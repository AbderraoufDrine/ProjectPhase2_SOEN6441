package com.example.assignment3.NewClass;

import java.text.ParseException;
import java.util.Scanner;

public class NewSetDriver {
    public static void main(String[] args) {
        NewSet<TestBase> test = new NewSet<>();

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Set Driver");
        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Add an object");
            System.out.println("2. Remove an object");
            System.out.println("3. Get the number of objects");
            System.out.println("4. Display objects");
            System.out.println("5. Does Object Exist");
            System.out.println("6. Check clone of new set");
            System.out.println("7. exit");

            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Please Enter the Id");
                    int id = input.nextInt();
                    System.out.println("Please Enter the Name");
                    String name = input.next();
                    TestBase obj = new TestBase(name, id);
                    System.out.println("The previous size of the set is: " + test.size());
                    test.add(obj);
                    System.out.println("The new size of the set is: " + test.size());
                    break;
                }
                case 2: {
                    System.out.println("Please Enter the Id");
                    int id = input.nextInt();
                    TestBase temp = test.delete(id);
                    System.out.println(temp);
                    break;
                }
                case 3:{
                    System.out.println("The number of objects is "+ test.size());
                    break;
                }
                case 4:{
                    test.displayElements();
                    break;
                }
                case 5:{
                    System.out.println("Please Enter the Id");
                    int id = input.nextInt();
                    System.out.println("Does the object exist? "+test.peek(id));
                    break;
                }
                case 6:{
                    NewSet<TestBase> testClone = new NewSet<>();
                    System.out.println("Are the sets the same? "+ test.equals(testClone));
                    break;
                }
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option between 1-7.");
                    break;
            }
        } while (choice != 7);

    }
}
