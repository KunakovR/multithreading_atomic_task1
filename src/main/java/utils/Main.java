package utils;

import static utils.Counter.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger counter3 = new AtomicInteger();
    public static AtomicInteger counter4 = new AtomicInteger();
    public static AtomicInteger counter5 = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        Thread palindrome = new Thread(() -> {
            for (String text : texts) {
                if (isPalindrome(text) && !isSameChar(text)) {
                    increment(text.length());
                }
            }
        });
        palindrome.start();

        Thread sameChar = new Thread(() -> {
            for (String text : texts) {
                if(isSameChar(text)) {
                    increment(text.length());
                }
            }
        });
        sameChar.start();

        Thread ascendingOrder = new Thread(() -> {
            for (String text : texts) {
                if(isSameChar(text) && isAscendingOrder(text)) {
                    increment(text.length());
                }
            }
        });
        ascendingOrder.start();

        sameChar.join();
        ascendingOrder.join();
        palindrome.join();

        System.out.println("Красивых слов с длиной 3: " + counter3);
        System.out.println("Красивых слов с длиной 4: " + counter4);
        System.out.println("Красивых слов с длиной 5: " + counter5);

    }

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int j = 0; j < length; j++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }

    public static void increment(int textLength) {
        if (textLength == 3) {
            counter3.getAndIncrement();
        } else if (textLength == 4) {
            counter4.getAndIncrement();
        } else {
            counter5.getAndIncrement();
        }
    }
}
