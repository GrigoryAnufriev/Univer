package Lab.Lab_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Sit implements Runnable {

    Semaphore sem;
    Integer name;
    Sit(Semaphore sem, Integer name){
        this.name = name;
        this.sem = sem;
    }

    public void run(){

        try {
            sem.acquire();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");
            System.out.println("Client " + name + " sit down " + formatter.format(date));
            Semaphore hairdresser = new Semaphore(3,true);

            new Thread(new Haircut(sem, hairdresser, name)).start();
        }
        catch (InterruptedException e){System.out.println(e.getMessage());}
    }
}