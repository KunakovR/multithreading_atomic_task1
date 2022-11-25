import java.util.Random;

public class Generator {

    public String[] texts;

    public Generator() {
        this.texts = nicknameGenerate();
    }

    private static String[] nicknameGenerate() {
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
