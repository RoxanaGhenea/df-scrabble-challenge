import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Scrabble {
    private List<Character> word = Collections.emptyList();
    private List<Character> doubleLetters = Collections.emptyList();
    private List<Character> tripleLetters = Collections.emptyList();
    private boolean doubleWord;
    private boolean tripleWord;
    private HashMap<Character, Integer> letterScores;
    {
        letterScores = new HashMap<>();
        letterScores.put(' ', 0);
        letterScores.put('A', 1);
        letterScores.put('B', 3);
        letterScores.put('C', 3);
        letterScores.put('D', 2);
        letterScores.put('E', 1);
        letterScores.put('F', 4);
        letterScores.put('G', 2);
        letterScores.put('H', 4);
        letterScores.put('I', 1);
        letterScores.put('J', 8);
        letterScores.put('K', 5);
        letterScores.put('L', 1);
        letterScores.put('M', 3);
        letterScores.put('N', 1);
        letterScores.put('O', 1);
        letterScores.put('P', 3);
        letterScores.put('Q', 10);
        letterScores.put('R', 1);
        letterScores.put('S', 1);
        letterScores.put('T', 1);
        letterScores.put('U', 1);
        letterScores.put('V', 4);
        letterScores.put('W', 4);
        letterScores.put('X', 8);
        letterScores.put('Y', 4);
        letterScores.put('Z', 10);
        letterScores.put('\n', 0);
        letterScores.put('\t', 0);
    }

    public Scrabble(String word) {
        if (word != null) {
            this.word = word.toUpperCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        }
    }

    public Scrabble(String word, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        if (word != null) {
            this.word = word.toUpperCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        }
        if (doubleLetters != null) {
            this.doubleLetters = Arrays.asList(doubleLetters);
        }
        if (tripleLetters != null) {
            this.tripleLetters = Arrays.asList(tripleLetters);
        }
    }

    private boolean validateLetters() {
        return this.word.stream().allMatch(c -> letterScores.containsKey(c));
    }

    private boolean validator() {
        return validateLetters();
    }

    private int computeValidScore() {
        return this.word.stream().mapToInt(c -> letterScores.get(c)).sum();
    }

    private int doubleWordScore(int baseScore) {
        if (this.doubleWord) {
            return baseScore * 2;
        }
        return baseScore;
    }

    private int tripleWordScore(int baseScore) {
        if (this.tripleWord) {
            return  baseScore * 3;
        }
        return baseScore;
    }

    private int doubleLetterScore() {
        if (this.doubleLetters == null) {
            return 0;
        }
        return this.doubleLetters.stream().mapToInt(c -> letterScores.get(Character.toUpperCase(c))).sum();
    }

    private int tripleLetterScore() {
        if (this.tripleLetters == null) {
            return 0;
        }
        return 2 * this.tripleLetters.stream().mapToInt(c -> letterScores.get(Character.toUpperCase(c))).sum();
    }

    private int finalScore() {
        int baseScore = (computeValidScore() + doubleLetterScore() + tripleLetterScore());
        int doubleScore = doubleWordScore(baseScore);
        return tripleWordScore(doubleScore);
    }

    public int score() {
        if (!validator()) {
            return 0;
        }
        return finalScore();
    }
}