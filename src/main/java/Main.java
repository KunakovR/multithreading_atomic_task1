public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();

        Thread thread1 = new Thread(null, () -> myThread.countNickname(3), "Красивых слов с длиной 3: ");
        Thread thread2 = new Thread(null, () -> myThread.countNickname(4), "Красивых слов с длиной 4: ");
        Thread thread3 = new Thread(null, () -> myThread.countNickname(5), "Красивых слов с длиной 5: ");

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
    }
}
