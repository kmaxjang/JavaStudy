package com.ex01.board;

import com.ex01.Group;
import com.ex01.board.TurnTimer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class TimeService {
  // 초기 범위상수
  public static final int StartTimeMin = 0;
  public static final int StartTimeMax = 3600;
  public static final int ChanceTimeMin = 10;
  public static final int ChanceTimeMax = 180;
  public static final int ChanceCountMax = 5;

  // countdown 상수
  private static final int Time = 0;
  private static final int ChanceCount = 1;
  private static final int Han = 0;
  private static final int Cho = 1;

  // countdown[player+Time]: 남은 시간
  // countdown[player+ChanceCount]: 남은 초읽기 횟수
  private int[] countdown = new int[4];

  private final int START_TIME;
  private final int CHANCE_COUNT;
  private final int CHANCE_TIME;

  private volatile boolean turn_change = false;
  private volatile int turn; // 현재 턴 플레이어 Han, Cho
  private TurnTimer[] player;
  private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

  private Thread tick_deliver;
  private Thread time_thread;
  private long tickcycle = 1000;

  public TimeService(int starttime, int chancetime, int chancecount) {
    START_TIME = range(StartTimeMin, StartTimeMax, starttime);
    CHANCE_TIME = range(ChanceTimeMin, ChanceTimeMax, chancetime);
    CHANCE_COUNT = range(1, ChanceCountMax, chancecount);
  }

  public void start(Group startgroup, TurnTimer han, TurnTimer cho) {
    if (startgroup == null || han == null || cho == null) return;
    if (player != null) return; // 중복 실행방지
    turn = startgroup.isHAN() ? Han : Cho;
    player = new TurnTimer[] {han, cho};
    turnUpdateDeliver();

    tick_deliver =
        new Thread(
            new Runnable() {
              public void run() {
                tickDeliver();
              }
            },
            "TimeService-TickDeliver");
    tick_deliver.start();

    // tick() 스레드 시작
    time_thread =
        new Thread(
            new Runnable() {
              public void run() {
                System.out.println("TimeStart");
                long start, end;
                long sleep = 0;
                resetTime();
                while (!Thread.currentThread().isInterrupted()) {
                  start = System.currentTimeMillis();
                  if (!tick()) break;
                  end = System.currentTimeMillis();
                  sleep = tickcycle - (end - start);
                  try {
                    Thread.sleep((sleep < 0) ? 0 : sleep);
                  } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                  }
                }
                System.out.println("TimeEnd");
              }
            },
            "TimeService-TickThread");
    time_thread.start();
  }

  public void stop() {
    if (time_thread != null && time_thread.isAlive()) {
      time_thread.interrupt();
    }
  }

  private boolean tick() {
    synchronized (this) {
      int group = turn * 2;
      countdown[group + Time]--;
      if (countdown[group + Time] <= 0) {
        countdown[group + ChanceCount]--;
        if (countdown[group + ChanceCount] <= 0) {
          return false;
        } else {
          countdown[group + Time] = CHANCE_TIME;
        }
      }
      return true;
    }
  }

  private void turnChange() {
    synchronized (this) {
      if (countdown[turn*2 + ChanceCount] != CHANCE_COUNT) {
        countdown[turn*2 + Time] = CHANCE_TIME;
        timeUpdateDeliver();
      }
      turn = (turn != Han) ? Han : Cho;
    }
    turnUpdateDeliver();
  }

  private void tickDeliver() {
    try {
      while (true) {
        queue.take();
        System.out.println("Tick");
        timeUpdateDeliver();
      }
    } catch (InterruptedException e) {
      // 종료
    }
  }

  private void turnUpdateDeliver() {
    System.out.println("TurnUpdate");
    player[Han].setTurn(createTurn(Han));
    player[Cho].setTurn(createTurn(Cho));
  }

  private void timeUpdateDeliver() {
    System.out.println("TimeUpdate");
    player[Han].setTimeMessage(turn == Han, countdown[turn + Time], countdown[turn + ChanceCount]);
    player[Cho].setTimeMessage(turn == Cho, countdown[turn + Time], countdown[turn + ChanceCount]);
  }

  private Turn createTurn(int group) {
    return new Turn() {

      public boolean isTurn() {
        return turn == group;
      }

      public void endTurn() {
        synchronized (TimeService.this) {
          if (turn == group) {
            turnChange();
          }
        }
      }
    };
  }

  private int range(int min, int max, int value) {
    if (value <= min) return min;
    if (value >= max) return max;
    return value;
  }

  private void resetTime() {
    countdown[Han * 2 + Time] = START_TIME;
    countdown[Han * 2 + ChanceCount] = CHANCE_COUNT;
    countdown[Cho * 2 + Time] = START_TIME;
    countdown[Cho * 2 + ChanceCount] = CHANCE_COUNT;
  }
}
