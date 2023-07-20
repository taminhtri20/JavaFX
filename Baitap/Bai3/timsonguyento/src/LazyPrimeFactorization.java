public class LazyPrimeFactorization implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            if (isPrime(i)==true){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int i){
        if (i<2){
            return false;
        }
        for (int j=2; j<=i/2; j++){
            if (i % j == 0){
                return false;
            }
        }
        return true;
    }
}
