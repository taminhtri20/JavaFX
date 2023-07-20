public class myThread extends Thread{
    @Override
    public void run(){
        System.out.println("MyThread Start");
        Thread myRunnableThread = new Thread(new MyRunable());
        myRunnableThread.start();

        try {
            myRunnableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyThread End");

    }
}
