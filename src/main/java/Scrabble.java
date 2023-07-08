import java.util.HashMap;
import java.lang.String;

public class Scrabble {
    private String word;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
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
    }

    public Scrabble(String word) {
        this.word = word;
        if (validateNull()) {
            this.word = this.word.toUpperCase();
        }
    }

    public Scrabble(String word, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        if (validateNull()) {
            this.word = this.word.toUpperCase();
        }
    }

    public boolean validateNull() {
        return this.word != null;
    }

    public int computeValidScore() {
        int answer = 0;
        for (char c : this.word.toCharArray()) {
            answer += letterScores.get(c);
        }
        return answer;
    }

    public int doubleWordScore() {
        if (this.doubleWord) {
            return computeValidScore() * 2;
        }
        return 0;
    }

    public int tripleWordScore() {
        if (this.tripleWord) {
            return  computeValidScore() * 3;
        }
        return 0;
    }

    public int doubleLetterScore() {
        int answer = 0;
        for (char c : this.doubleLetters) {
            answer += letterScores.get(c);
        }
        return answer;
    }

    public int score() {
        if (!validateNull()) {
            return 0;
        }
        if (this.doubleWord || this.tripleWord) {
            return doubleWordScore() + tripleWordScore();
        }
        if (this.doubleLetters != null) {
            return computeValidScore() + doubleLetterScore();
        }
        return computeValidScore();
    }
}

