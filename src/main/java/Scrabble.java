import java.util.HashMap;

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
        letterScores.put('\n', 0);
        letterScores.put('\t', 0);
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

    private boolean validateNull() {
        return this.word != null;
    }

    private boolean validateLetters() {
        for (char c : this.word.toCharArray()) {
            if (!letterScores.containsKey(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean validator() {
        return validateNull() && validateLetters();
    }

    public int computeValidScore() {
        int answer = 0;
        for (char c : this.word.toCharArray()) {
            answer += letterScores.get(c);
        }
        return answer;
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
        int answer = 0;
        if (this.doubleLetters != null) {
            for (char c : this.doubleLetters) {
                answer += letterScores.get(Character.toUpperCase(c));
            }
        }
        return answer;
    }

    private int tripleLetterScore() {
        int answer = 0;
        if (this.tripleLetters != null) {
            for (char c : this.tripleLetters) {
                answer += letterScores.get(Character.toUpperCase(c));
            }
        }
        return answer * 2;
    }

    private int finalScore() {
        int baseScore = computeValidScore() + doubleLetterScore() + tripleLetterScore();
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

