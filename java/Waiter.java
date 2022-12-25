public class Waiter implements Runnable{
    private final int orderQty;
    private final int customerid;
    static int foodPrice = 25000;

    public Waiter(int customerid, int orderQty) {
        this.customerid = customerid;
        this.orderQty = orderQty;
    }
 
    @Override
    public void run() {
        while (true) {
            getFood();
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void orderInfo() {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Customer id: " + this.customerid);
        System.out.println("Numbeer of food: " + this.orderQty);
        System.out.println("Total price: " + this.orderQty * foodPrice);
        System.out.println("-----------------------------------------------------------");
    }

    public void getFood() {
        synchronized(Restaurant.getLock()) {

            System.out.println("Waiter:food is ready to delivery");
            Restaurant food = new Restaurant();
            food.setwaitingforpickup(false);
            if (Restaurant.getcoffeenumber() == this.orderQty + 1) {
                orderInfo();
                System.exit(0);
            }
            Restaurant.getLock().notifyAll();
            System.out.println("Waiter:tell the restaurant to make another food\n");

        }
    }
}
