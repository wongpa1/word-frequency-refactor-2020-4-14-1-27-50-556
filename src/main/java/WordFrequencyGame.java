import java.util.*;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String NEXT_LINE_DELIMITER = "\n";
    public static final String SPACE_DELIMITER = " ";
    public static final String CALCULATE_ERROR = "Calculate Error";

    public String getResult(String sentence) {

        try {
            List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
            wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
            return formatWordFrequencyResult(wordInfoList);
        } catch (Exception exception) {
            return CALCULATE_ERROR;
        }
    }

    private List<WordInfo> calculateWordFrequency(String sentence) {
        List<String> wordArray = Arrays.asList(sentence.split(SPACE_PATTERN));
        List<WordInfo> wordInfoList = new ArrayList<>();

        for (String word : new HashSet<>(wordArray)) {
            int count = Collections.frequency(wordArray, word);
            wordInfoList.add(new WordInfo(word, count));
        }
        return wordInfoList;
    }

    private String formatWordFrequencyResult(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(NEXT_LINE_DELIMITER);
        for (WordInfo wordinfo : wordInfoList) {
            String wordWithCount = wordinfo.getWord() + SPACE_DELIMITER + wordinfo.getWordCount();
            joiner.add(wordWithCount);
        }
        return joiner.toString();
    }
}
