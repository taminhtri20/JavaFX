public class evenNumberRunable implements Runnable{
    @Override
    public void run() {
        for (int i = 2; i<=10; i+=2){
            System.out.println(i);
        }
    }
}
