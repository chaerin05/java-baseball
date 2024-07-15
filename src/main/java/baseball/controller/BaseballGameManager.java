package baseball.controller;

import baseball.GameView;
import baseball.model.Game;
import baseball.service.GameService;
import baseball.service.RandomNumberGenerator;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameManager {

    private final Game game;
    private final GameService gameService;
    private final GameView gameView;
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public BaseballGameManager(Game game, GameService gameService, GameView gameView) {
        this.game = game;
        this.gameService = gameService;
        this.gameView = gameView;
    }

    public void startGame() {
        gameView.printMessage("숫자 야구 게임을 시작합니다.");
        gameView.printMessage("정답(확인용): " + game.getAnswer()); // 확인용

        while (true) {
            String userInput = gameView.getUserInput("숫자를 입력하시오: ");

            if (userInput.equals(game.getAnswer())) {
                gameView.printMessage("3 스트라이크");
                gameView.printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                restartGame();
                break; // 무한 루프 종료
            } else {
                String result = gameService.checkGuess(userInput);
                gameView.printMessage(result);
            }
        }
    }

    public void restartGame(){
        String userInput = gameView.getUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        if (userInput.equals("1")) {
            gameService.restartGame();
            startGame();

        } else if (userInput.equals("2")) {
            gameView.printMessage("게임을 종료합니다.");

        } else {
            gameView.printMessage("잘못된 입력입니다. 게임을 종료합니다.");
        }
    }
}
