package baseball;

import camp.nextstep.edu.missionutils.Console;


public class GameView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return Console.readLine();
    }
}