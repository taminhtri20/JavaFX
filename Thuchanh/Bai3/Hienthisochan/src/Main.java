public class Main {
    public static void main(String[] args) {
        evenNumberRunable evenNumberRunable = new evenNumberRunable();
        Thread evenThread = new Thread(evenNumberRunable);
        evenThread.start();
    }
}