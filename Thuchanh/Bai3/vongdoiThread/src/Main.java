public class Main {
    public static void main(String[] args) {
        myThread myThread = new myThread();

        myThread.start();

        try {
            Thread.sleep(20000);
            System.out.println("MyThread State: " + myThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}