import java.util.HashMap;

public class Scrabble {
    private String wordToScore;
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

    public Scrabble(String wordToScore) {
        this.wordToScore = wordToScore;
        if (validateNull()) {
            this.wordToScore = this.wordToScore.toUpperCase();
        }
    }

    public int score() {
        if (!validateNull()) {
            return 0;
        }
        return computeValidScore();
    }
    public int computeValidScore() {
        int answer = 0;
        for (char c : wordToScore.toCharArray()) {
            answer += letterScores.get(c);
        }
        return answer;
    }

    public boolean validateNull() {
        return this.wordToScore != null;
    }
}

