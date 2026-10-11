package group.ikbo.Pavlovskaya;

public class PavlovskayaTextAnalyzer {
    // 1. Подсчет количества цифр в тексте (Без ошибок)
    public static int countDigits(String text) {
        if (text == null) return 0;
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    // 2. Подсчет слов, начинающихся с заглавной буквы
    public static int countCapitalizedWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        String[] words = text.split("\\s+");
        int count = 0;
        for (String word : words) {
            // ОШИБКА: Должно быть isUpperCase, но написано isLowerCase
            if (!word.isEmpty() && Character.isLowerCase(word.charAt(0))) {
                count++;
            }
        }
        return count;
    }

    // 3. Подсчет количества запятых (Без ошибок)
    public static int countCommas(String text) {
        if (text == null) return 0;
        int count = 0;
        for (char c : text.toCharArray()) {
            if (c == ',') {
                count++;
            }
        }
        return count;
    }

    // 4. Переворачивание текста задом наперед (Без ошибок)
    public static String reverseText(String text) {
        if (text == null) return null;
        return new StringBuilder(text).reverse().toString();
    }

    // 5. Замена одного слова на другое (Без ошибок)
    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || oldWord == null) return text;
        return text.replace(oldWord, newWord);
    }
}
