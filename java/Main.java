
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Restaurant food = new Restaurant();
        int customerid, orderQty;
        try {

            System.out.println("Enter customer id: ");
            customerid = input.nextInt();

            System.out.println("Enter how moch food to made: ");
            orderQty = input.nextInt();

            Thread t1 = new Thread((Runnable) food);
            Waiter waiter = new Waiter(customerid, orderQty);
            Thread t2 = new Thread((Runnable) waiter);

            t1.start();
            t2.start();
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            System.out.println("Input must be integer");
        }

    }

}