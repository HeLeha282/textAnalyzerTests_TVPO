package group.ikbo.Yurchenko;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YurchenkoTextAnalyzer {

    // 1) Является ли строка палиндромом
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str;
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2) Подсчет количества заглавных букв в тексте
    public static int countUppercaseLetters(String str) {
        if (str == null) return 0;
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    // 3) Извлечение всех чисел из текста в список
    public static List<Integer> extractNumbers(String str) {
        if (str == null) return new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            numbers.add(Integer.parseInt(matcher.group()));
        }
        return numbers;
    }

    // 4) Подсчет количества слов заданной длины
    public static int countWordsOfLength(String str, int length) {
        if (str == null || str.trim().isEmpty()) return 0;
        int count = 0;
        String[] words = str.split("\\s+");
        for (String word : words) {
            String cleanWord = word.replaceAll("\\p{Punct}", "");
            if (cleanWord.length() == length) {
                count++;
            }
        }
        return count;
    }

    // 5) Нормализация пробелов
    public static String normalizeSpaces(String str) {
        if (str == null) return null;
        return str.trim().replaceAll("\\s+", " ");
    }
}

