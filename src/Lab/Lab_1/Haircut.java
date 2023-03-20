package Lab.Lab_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Haircut implements Runnable {

    Semaphore sem_free;
    Semaphore sem;
    Integer name;
    Haircut(Semaphore sem_free, Semaphore sem, Integer name){
        this.sem_free = sem_free;
        this.name = name;
        this.sem = sem;
    }

    public void run(){

        try {
            sem.acquire();
            sem_free.release();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");
            System.out.println("Client " + name + " haircutting " + formatter.format(date));
            Thread.sleep(1000 * ((int)(Math.random() * ((4 - 1) + 1)) + 1));

            new Thread(new Buy(sem, name)).start();
        }
        catch (InterruptedException e){System.out.println(e.getMessage());}
    }
}
