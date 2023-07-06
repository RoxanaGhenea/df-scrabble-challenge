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
        int answer = 0;
        for (char c : wordToScore.toCharArray()) {
            answer += letterScores.get(c);
        }
        return answer;
    }
}

