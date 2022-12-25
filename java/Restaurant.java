public class Restaurant implements Runnable{

    static int getcoffeenumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private boolean waitingForPickup = false;
    private static final Object lock = new Object();
    private static int foodNumber = 1;

    @Override
    public void run() {
        while (true) {
            makeFood();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void setWaitingForPickup(boolean waitingForPickup) {
        this.waitingForPickup = waitingForPickup;
    }

    public static int getCoffeeNumber() {
        return foodNumber;
    }

    public void makeFood() {
        synchronized(Restaurant.lock) {
            if (this.waitingForPickup) {
                try {
                    System.out.println("Restaurant:Waiting for the waiter to deliver the food");
                    Restaurant.lock.wait();
                } catch (InterruptedException e) {
                }

            }
            waitingForPickup = true;
            System.out.println("Restaurant:making food number" + foodNumber++);
            Restaurant.lock.notifyAll();
            System.out.println("Restaurant:telling the waiter to get the coffee\n");
        }
    }

    public static Object getLock() {
        return lock;
    }

    void setwaitingforpickup(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
