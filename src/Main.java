import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        boolean quit = false;

        while (!quit) {
            System.out.println("Introduceți opțiunea dorită:");
            System.out.println("1 - Adăugare înregistrare");
            System.out.println("2 - Eliminare înregistrare");
            System.out.println("3 - Afișare înregistrare din vârful stivei");
            System.out.println("4 - Ieșire");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumă \n lăsat de scanner.nextInt()

                switch (choice) {
                    case 1:
                        System.out.println("Introduceți numele înregistrării:");
                        String name = scanner.nextLine();

                        System.out.println("Introduceți valoarea înregistrării:");
                        int value = scanner.nextInt();
                        scanner.nextLine(); // Consumă \n lăsat de scanner.nextInt()

                        stack.push(name + " " + value);
                        System.out.println("Înregistrarea a fost adăugată cu succes.");
                        break;

                    case 2:
                        String removedRecord = stack.pop();
                        System.out.println("Înregistrarea " + removedRecord + " a fost eliminată cu succes.");
                        break;

                    case 3:
                        String peekedRecord = stack.peek();
                        System.out.println("Înregistrarea din vârful stivei este: " + peekedRecord);
                        break;

                    case 4:
                        quit = true;
                        break;

                    default:
                        System.out.println("Opțiune invalidă.");
                }
            } catch (StackOverflowError e) {
                System.out.println("Eroare: " + e.getMessage());
            } catch (EmptyStackException e) {
                System.out.println("Eroare: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Eroare: Opțiunea introdusă nu este validă.");
                scanner.nextLine(); // Consumă \n lăsat de scanner.nextInt() în cazul în care nu s-a introdus un număr
            }

            System.out.println();
        }

        scanner.close();
    }
}
