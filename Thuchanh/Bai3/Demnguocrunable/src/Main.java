public class Main {
    public static void main(String[] args) {
        countDown countDown = new countDown();
        Thread thread = new Thread(countDown);
        thread.start();
    }
}