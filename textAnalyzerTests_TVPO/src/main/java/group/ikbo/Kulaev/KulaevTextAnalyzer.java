package group.ikbo.Kulaev;

import java.util.*;

public class KulaevTextAnalyzer {

    // 1) Количество слов в тексте (с ошибкой)
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length - 1; // ОШИБКА: должно быть words.length
    }

    // 2) Количество предложений в тексте
    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == '.' || c == '!' || c == '?') {
                count++;
            }
        }
        return count;
    }

    // 3) Самое часто встречающееся слово
    public static String mostFrequentWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return "";
        }
        String[] words = text.toLowerCase()
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ\\s]", "")
                .trim().split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        String mostFrequent = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequent = entry.getKey();
            }
        }
        return mostFrequent;
    }

    // 4) Количество гласных и согласных букв
    public static int[] countVowelsAndConsonants(String text) {
        String vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouAEIOU";
        int vowelsCount = 0;
        int consonantsCount = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowels.indexOf(c) != -1) {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }
        return new int[]{vowelsCount, consonantsCount};
    }

    // 5) Средняя длина слова
    public static double averageWordLength(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0.0;
        }
        String[] words = text.trim().split("\\s+");
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return (double) totalLength / words.length;
    }
}