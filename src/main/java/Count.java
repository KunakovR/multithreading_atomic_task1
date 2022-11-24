import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Count {

    private static int countForThree = 0;
    private static int countForFour = 0;
    private static int countForFive = 0;

    Generator generator = new Generator();
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void countNickname(int length) {
        atomicInteger.set(length);
        int count = atomicInteger.get();
            for (int i = 0; i < generator.texts.length; i++) {
                if (generator.texts[i].length() == count && count == 3) {
                    if (palindrom(generator.texts[i]) == true) {
                        countForThree++;
                    }
                    if (equalsChar(generator.texts[i]) == true) {
                        countForThree++;
                    }
                    else if (sortChar(generator.texts[i]) == true) {
                        countForThree++;
                    }
                }
                if (generator.texts[i].length() == count && count == 4) {
                    if (palindrom(generator.texts[i]) == true) {
                        countForFour++;
                    }
                    if (equalsChar(generator.texts[i]) == true) {
                        countForFour++;
                    }
                    else if (sortChar(generator.texts[i]) == true) {
                        countForFour++;
                    }
                }
                if (generator.texts[i].length() == count && count == 5) {
                    if (palindrom(generator.texts[i]) == true) {
                        countForFive++;
                    }
                    if (equalsChar(generator.texts[i]) == true) {
                        countForFive++;
                    }
                    else if (sortChar(generator.texts[i]) == true) {
                        countForFive++;
                    }
                }
            }
            if (count == 3) {
                System.out.println(Thread.currentThread().getName() + countForThree);
            }
            if (count == 4) {
                System.out.println(Thread.currentThread().getName() + countForFour);
            }
            if (count == 5) {
                System.out.println(Thread.currentThread().getName() + countForFive);
            }
    }

    public static boolean palindrom(String nickname) {
        char[] word = new char[nickname.length()];
        for (int v = 0; v < nickname.length(); v++) {
            word[v] = nickname.charAt(v);
        }
        int i = 0;
        int j = word.length - 1;
        while (j > i) {
            if (word[i] != word[j]) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public static boolean equalsChar(String nickname) {
        char[] word = new char[nickname.length()];
        for (int v = 0; v < nickname.length(); v++) {
            word[v] = nickname.charAt(v);
        }
        int i = 0;
        int j = word.length - 1;
        while (j > i) {
            if (word[i] != word[j]) {
                return false;
            }
            ++i;
        }
        return true;
    }

    public static boolean sortChar(String nickname) {
        char[] word = new char[nickname.length()];
        for (int v = 0; v < nickname.length(); v++) {
            word[v] = nickname.charAt(v);
        }
        int i = 0;
        int j = word.length - 1;
        while (j > i) {
            if (word[i] > word[i + 1]) {
                return false;
            }
            ++i;
        }
        return true;
    }


    public static class Generator {

        String[] texts;

        public Generator() {
            this.texts = nicknameGenerate();
        }

        public static String[] nicknameGenerate() {
            Random random = new Random();
            String[] texts = new String[100_000];
            for (int i = 0; i < texts.length; i++) {
                texts[i] = generateText("abc", 3 + random.nextInt(3));
            }
            return texts;
        }

        private static String generateText(String letters, int length) {
            Random random = new Random();
            StringBuilder text = new StringBuilder();
            for (int j = 0; j < length; j++) {
                //random.nextInt(letters.length()) метод возвращает случайное целое число в диапазоне [0, max). 0 входит в диапазон, max — не входит.
                //letters.charAt по индексу возвращает символ из строки
                //text.append прибавляет символ к создаваемой строке
                text.append(letters.charAt(random.nextInt(letters.length())));
            }
            return text.toString();
        }

    }
}
