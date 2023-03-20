package Lab.Lab_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


public class Main {

    public static int people = 3;

    public static void main(String[] args){

        int kol = 0;
        while (kol != 50) {
            if (people <= 20) {
                kol++;
                people++;
                try{ entered(kol); }
                catch (InterruptedException e) { e.printStackTrace(); }
            }
            else
                System.out.println("Client couldn't enter");
        }
    }



    public static void entered(int kol) throws InterruptedException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss:SS");
        System.out.println("Client " + kol + " entered " + formatter.format(date));
        Semaphore sofa = new Semaphore(4,true);

        new Thread(new Sit(sofa, kol)).start();
        TimeUnit.MILLISECONDS.sleep(1500);
//        TimeUnit.SECONDS.sleep((int)(Math.random() * ((2 - 1) + 1)) + 1);

    }

}






