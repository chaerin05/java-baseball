package baseball;


import baseball.controller.BaseballGameManager;
import baseball.model.Game;
import baseball.service.GameService;

public class Application {
   public static void main(String[] args) {
      Game game = new Game();
      GameService gameService = new GameService(game);
      GameView gameView = new GameView();
      BaseballGameManager baseballGameManager = new BaseballGameManager(game, gameService, gameView);
      baseballGameManager.startGame();

   }
}
