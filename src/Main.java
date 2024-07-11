import java.lang.Thread;
import java.util.Random;
class Looping extends Thread {
    private int count = 0;
    private Random random;
    public Looping(){
        this.random = new Random();
    }
    public synchronized void panggil(int nomerThread) {
        for (int i = 1; i <= this.random.nextInt(10); i++) {
            System.out.println("ini thread ke " + nomerThread + " perulangan ke " + i);
            this.count += 1;
        }
    }
    public synchronized int getCount() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Looping looping = new Looping();

        Thread thread1 = new Thread(() -> looping.panggil(1));
        Thread thread2 = new Thread(() -> looping.panggil(2));

        thread2.start();
        thread1.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total looping yang dilakukan : " + looping.getCount());
    }
}
