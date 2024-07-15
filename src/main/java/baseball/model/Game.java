package baseball.model;

import baseball.service.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private String answer;

    public Game() {
        this.answer = randomNumberGenerator.getAnswer();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String generateRandomAnswer() {
        return randomNumberGenerator.getAnswer();
    }
}
