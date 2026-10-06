package group.ikbo.Nadmitov;

import java.util.*;

public class NadmitovTextAnalyzer {

    // 1) длина текста
    public static Integer lenText(String str){
        return str == null ? 0 : str.length();
    }

    // 2) колво уникальных символов
    public static Integer countUniqChars(String str){
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            set.add(c);
        }

        return set.size();
    }

    //3) самое длинное слово
    public static String maxLengthWord(String str) {
        return Arrays.stream(str.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElseGet(()->null);
    }

    //4) самое короткое слово
    public static String minLengthWord(String str) {
        return Arrays.stream(str.split("\\s+"))
                .min(Comparator.comparingInt(String::length))
                .orElseGet(()->null);
    }

    // 5) сколько раз встречается каждый символ в тексте
    public static Map<Character, Integer> getCharFrequencies(String str){
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.merge(c,0,Integer::sum);
        }

        return map;
    }

}
