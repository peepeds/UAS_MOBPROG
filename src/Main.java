
class Looping{
    public synchronized void panggil(int nomerThread , int many){
        for(int i = 1 ; i <= many ; i++){
            System.out.println("ini thread ke " + nomerThread + " perulangan ke " + i);
        }
    }
}
public class Main
{
    public static void main(String[] args) {
        Looping looping = new Looping();

        Thread thread1 = new Thread(){
            public void run() { looping.panggil(1,3); }
        };

        Thread thread2 = new Thread(){
            public void run() { looping.panggil(2,3); }
        };

        thread2.start();
        thread1.start();


    }
}