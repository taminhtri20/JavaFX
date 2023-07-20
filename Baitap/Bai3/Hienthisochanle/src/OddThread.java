public class OddThread extends Thread{
    @Override
    public void run(){
        for (int i=0 ; i<11; i+=2){
            System.out.println(i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
