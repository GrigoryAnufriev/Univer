package Lab.Lab_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Buy implements Runnable {

    Semaphore sem;
    Integer name;
    Buy(Semaphore sem, Integer name){
        this.name = name;
        this.sem = sem;
    }

    public void run(){

        try {
            sem.release();
            sem.acquire();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");
            System.out.println("Client " + name + " paying " + formatter.format(date));
            Thread.sleep(1000 * ((int)(Math.random() * ((2 - 1) + 1)) + 1));
        }
        catch (InterruptedException e){System.out.println(e.getMessage());}

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");
        System.out.println("Client " + name + " quit " + formatter.format(date));
        Main.people--;
        sem.release();
    }

}
