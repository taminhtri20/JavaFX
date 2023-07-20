public class OptimizedPrimeFactorization implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int i){
        if (i<2){
            return false;
        }
        for (int j=2; j<=Math.sqrt(i); j++){
            if (i % j == 0){
                return false;
            }
        }
        return true;
    }
}
