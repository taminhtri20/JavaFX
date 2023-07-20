import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập một số nguyên để các thread đoán: ");
        int guessNumber = scanner.nextInt();

        guessNummber guessNummber1 = new guessNummber(guessNumber);
        guessNummber guessNummber2 = new guessNummber(guessNumber);

        Thread thread1 = new Thread(guessNummber1);
        Thread thread2 = new Thread(guessNummber2);

        thread1.setName("Thread1");
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
    }
}