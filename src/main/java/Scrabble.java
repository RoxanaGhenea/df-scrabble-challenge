import java.util.HashMap;
public class Scrabble {
    private String wordToScore;
    private HashMap<Character, Integer> letterScores;
    {
        letterScores = new HashMap<>();
        letterScores.put(' ', 0);
    }

    public Scrabble(String wordToScore) {
        this.wordToScore = wordToScore;
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

