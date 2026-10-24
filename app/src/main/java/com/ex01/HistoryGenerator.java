package com.ex01;

import java.util.Random;

public class HistoryGenerator {

//  private static final String[] PLAYERS = {"한", "초"};
  private static final String[] PIECES = {"왕", "차", "포", "마", "상", "사", "졸"};
  private static final String[] SPECIAL_COMMANDS = {"한수쉼", "기권패", "시간패", "점수패", "외통패", "접속끈김"};
  private static final Random RANDOM = new Random();

  public static void main(String[] args) {
    StringBuilder history = new StringBuilder();
    history.append("History:\n");

    int numberOfEntries = 200; // 생성할 항목 수 (1 ~ 200)

    for (int i = 1; i <= numberOfEntries; i++) {
      history.append(i).append(" ");

      // 무작위로 한 또는 초 선택
//      String player = PLAYERS[RANDOM.nextInt(PLAYERS.length)];
 //     history.append(player).append(" ");

      // 특수 명령어가 랜덤으로 추가될 경우
      if (RANDOM.nextBoolean()) {
        // 특수 명령어 추가
        String specialCommand = SPECIAL_COMMANDS[RANDOM.nextInt(SPECIAL_COMMANDS.length)];
        history.append(specialCommand).append("\n");
      } else {
        // 말 종류 선택
        String piece = PIECES[RANDOM.nextInt(PIECES.length)];
        history.append(piece);

        // 좌표 생성 (00 ~ 89)
        String currentPosition = String.format("%02d", RANDOM.nextInt(90));
        String previousPosition = String.format("%02d", RANDOM.nextInt(90));
        history.append(currentPosition).append(" ").append(previousPosition);

        // 잡은 말 종류가 있을 경우 추가
        if (RANDOM.nextBoolean()) {
          String capturedPiece = PIECES[RANDOM.nextInt(PIECES.length)];
          history.append(capturedPiece);
        }

        history.append("\n");
      }
    }

    System.out.println(history.toString());
  }
}
