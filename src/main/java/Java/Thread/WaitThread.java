package Java.Thread;

public class WaitThread implements Runnable{

    private Service service;

    public WaitThread(Service service){
        this.service = service;
    }

    public void run(){
        service.mWait();
    }

}
