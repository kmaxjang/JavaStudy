package com.ex18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Mark {
// 이모지 목록
  private final List<String> valuelist = new ArrayList<>(32);
  // key이름 과 이모지 위치
  private final HashMap<String, Integer> keymap = new HashMap<>(32);

  private static Mark mark = new Mark();

  public static String get(String key) {
    Integer index = mark.keymap.get(key);
    return (index != null)? mark.valuelist.get(index): null;
  }

  public static String get(int index) {
    if (index >= 0 && index < size()) {
      return mark.valuelist.get(index);
    }
    return null;
  }
  
  public static int size(){
    return mark.valuelist.size();
  }

  private Mark() {
    String[] defaultmap = {
      "0", "0️⃣",
      "1", "1️⃣",
      "2", "2️⃣",
      "3", "3️⃣",
      "4", "4️⃣",
      "5", "5️⃣",
      "6", "6️⃣",
      "7", "7️⃣",
      "8", "8️⃣",
      "9", "9️⃣", // 0~9
      "turn_on", "🔴",
      "turn_off", "⚫️", // 10~11
      "life_on", "❤️",
      "life_off", "💔", // 12~ 13
      "board_background", "⬜️", // 14
      "movable", "⭕️",
      "immovable", "🚫",
      "can_capture", "❌️",
      "cannot_capture", "✖️", // 15~18
      "piece_cho_king", "🦁",
      "piece_cho_cha", "🐵",
      "piece_cho_poo", "🐔",
      "piece_cho_ma", "🐴",
      "piece_cho_sang", "🐮",
      "piece_cho_sa", "🐱",
      "piece_cho_jol", "🐶", // 19~ 25
      "piece_han_king", "🐅",
      "piece_han_cha", "🐒",
      "piece_han_poo", "🦅",
      "piece_han_ma", "🐎",
      "piece_han_sang", "🐃",
      "piece_han_sa", "🐈",
      "piece_han_jol", "🐕" // 26~32
    };

    for (int i = 0; i < defaultmap.length; i+=2) {
      add(defaultmap[i], defaultmap[i + 1]);
    }
  }

  private void add(String keyname, String value) {
    keymap.put(keyname, valuelist.size());
    valuelist.add(value);
  }
}
