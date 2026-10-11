package group.ikbo.Kulaev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты функций KulaevTextAnalyzer (Надмитов)")
public class KulaevFunctionsNadmitovTest {
    @Test
    @DisplayName("Подсчёт количества слов в тексте")
    void countWords_returnsNumberOfWords() {
        assertEquals(4, KulaevTextAnalyzer.countWords("Привет мир как дела"));
    }
    @Test
    @DisplayName("Подсчёт количества предложений в тексте")
    void countSentences_countsEndPunctuation() {
        assertEquals(3, KulaevTextAnalyzer.countSentences("Привет! Как дела? Всё хорошо."));
    }
    @Test
    @DisplayName("Поиск самого часто встречающегося слова")
    void mostFrequentWord_returnsMostRepeatedWord() {
        assertEquals("кот", KulaevTextAnalyzer.mostFrequentWord("Кот, собака, кот и мышь. Кот!"));
    }
    @Test
    @DisplayName("Подсчёт гласных и согласных букв")
    void countVowelsAndConsonants_countsLettersCorrectly() {
        // "Привет": гласные и, е (2); согласные п, р, в, т (4)
        assertArrayEquals(new int[]{2, 4}, KulaevTextAnalyzer.countVowelsAndConsonants("Привет"));
    }
    @Test
    @DisplayName("Вычисление средней длины слова")
    void averageWordLength_returnsMeanLength() {
        // "кот" = 3, "собака" = 6 -> (3 + 6) / 2 = 4.5
        assertEquals(4.5, KulaevTextAnalyzer.averageWordLength("кот собака"), 0.0001);
    }
    @Test
    @DisplayName("При равной частоте возвращается первое встреченное слово")
    void mostFrequentWord_tie_returnsFirst() {
        assertEquals("собака", KulaevTextAnalyzer.mostFrequentWord("собака кот кот собака"));
    }

    // ===================== Граничные случаи: null, "", "   " =====================
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("Пустой ввод: количество слов равно 0")
    void countWords_emptyInput_returnsZero(String text) {
        assertEquals(0, KulaevTextAnalyzer.countWords(text));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("Пустой ввод: количество предложений равно 0")
    void countSentences_emptyInput_returnsZero(String text) {
        assertEquals(0, KulaevTextAnalyzer.countSentences(text));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("Пустой ввод: самое частое слово — пустая строка")
    void mostFrequentWord_emptyInput_returnsEmpty(String text) {
        assertEquals("", KulaevTextAnalyzer.mostFrequentWord(text));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("Пустой ввод: гласных и согласных 0")
    void countVowelsAndConsonants_emptyInput_returnsZeros(String text) {
        assertArrayEquals(new int[]{0, 0}, KulaevTextAnalyzer.countVowelsAndConsonants(text));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    @DisplayName("Пустой ввод: средняя длина слова равна 0")
    void averageWordLength_emptyInput_returnsZero(String text) {
        assertEquals(0.0, KulaevTextAnalyzer.averageWordLength(text), 0.0001);
    }
}