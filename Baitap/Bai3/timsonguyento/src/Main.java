public class Main {
    public static void main(String[] args) {
        LazyPrimeFactorization lazyPrimeFactorization = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedPrimeFactorization = new OptimizedPrimeFactorization();

        Thread thread1 = new Thread(lazyPrimeFactorization);
        Thread thread2 = new Thread(optimizedPrimeFactorization);

        thread1.start();
        thread2.start();
    }
}