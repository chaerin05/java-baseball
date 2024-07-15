package baseball.service;


import baseball.model.Game;

public class GameService {
    private final Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public String checkGuess(String guess) {
        String answer = game.getAnswer();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == answer.charAt(i)) {
                strike++;
            } else if (answer.contains(String.valueOf(guess.charAt(i)))) {
                ball++;
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        } else {
            return strike + " 스트라이크, " + ball + " 볼";
        }
    }

    public void restartGame() {
        game.setAnswer(game.generateRandomAnswer());
    }
}
