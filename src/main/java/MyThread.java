import java.util.concurrent.atomic.AtomicInteger;

public class MyThread {

    private static char[] nickname = {};

    Generator generator = new Generator();
    Counter counter = new Counter();
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void countNickname(int length) {
        atomicInteger.set(length);
        int count = atomicInteger.get();
        for (int i = 0; i < generator.texts.length; i++) {
            if (generator.texts[i].length() == count) {
                if (palindrom(generator.texts[i]) == true || sortChar(generator.texts[i]) == true) {
                    counter.setCount(count);
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + counter.getCount(count));
    }

    private static char[] getNicknameChar(String nick) {
        nickname = new char[nick.length()];
        for (int v = 0; v < nick.length(); v++) {
            nickname[v] = nick.charAt(v);
        }
        return nickname;
    }

    private static boolean palindrom(String nick) {
        getNicknameChar(nick);
        int i = 0;
        int j = nickname.length - 1;
        while (j > i) {
            if (nickname[i] != nickname[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    private static boolean sortChar(String nick) {
        getNicknameChar(nick);
        int i = 0;
        int j = nickname.length - 1;
        while (j > i) {
            if (nickname[i] > nickname[i + 1]) {
                return false;
            }
            ++i;
        }
        return true;
    }
}
