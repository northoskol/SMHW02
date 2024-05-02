import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        Scanner scanner = new Scanner(System.in);

        toyShop.addNewToy(1, "Teddy Bear", 10, 20);
        toyShop.addNewToy(2, "Doll", 15, 30);
        toyShop.addNewToy(3, "Toy Car", 20, 50);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Draw a Toy");
            System.out.println("2. Display Available Toys");
            System.out.println("3. Add New Toy");
            System.out.println("4. Change Toy Drop Frequency");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    toyShop.drawToy();
                    break;
                case 2:
                    toyShop.displayToys();
                    break;
                case 3:
                    System.out.print("Enter toy ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter toy name: ");
                    String name = scanner.next();
                    System.out.print("Enter toy quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter toy drop frequency (%): ");
                    int dropFrequency = scanner.nextInt();
                    toyShop.addNewToy(id, name, quantity, dropFrequency);
                    break;
                case 4:
                    System.out.print("Enter toy ID: ");
                    int toyId = scanner.nextInt();
                    System.out.print("Enter new drop frequency (%): ");
                    int newFrequency = scanner.nextInt();
                    toyShop.changeToyDropFrequency(toyId, newFrequency);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}