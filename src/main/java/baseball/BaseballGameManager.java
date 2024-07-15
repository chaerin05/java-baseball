package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGameManager {
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println("test.");
        while (true) {
            String answer = randomNumberGenerator.getAnswer();
            System.out.println("정답(확인용): " + answer);
            boolean gameRunning = true;

            while (gameRunning) {
                System.out.print("숫자를 입력하시오: ");
                String userInput = Console.readLine();

                if (userInput.equals(answer)) {
                    System.out.println("3 스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    String userInput2 = Console.readLine();
                    if (userInput2.equals("1")) {
                        gameRunning = false; // 현재 게임 루프 종료
                    } else if (userInput2.equals("2")) {
                        System.out.println("게임을 종료합니다.");
                        return; // 프로그램 종료
                    } else {
                        System.out.println("잘못된 입력입니다. 게임을 종료합니다.");
                        return; // 프로그램 종료
                    }
                } else {
                    int strike = 0;
                    int ball = 0;

                    for (int i = 0; i < userInput.length(); i++) {
                        char userChar = userInput.charAt(i);
                        if (userChar == answer.charAt(i)) {
                            strike++;
                        } else if (answer.contains(String.valueOf(userChar))) {
                            ball++;
                        }
                    }

                    if (strike == 0 && ball == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.println(strike + " 스트라이크, " + ball + " 볼");
                    }
                }
            }
        }
    }
}
