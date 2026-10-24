package com.ex01;

public final class Config<T> {

  private final T value;

  private Config(T value) {
    this.value = value;
  }

  public T value() {
    return value;
  }

  public static final Config<Integer> Board_X = new Config<>(9);
  public static final Config<Integer> Board_Y = new Config<>(10);
  public static final Config<Integer> Board_Length = new Config<>(90);
  public static final Config<String> Tile_Background = new Config<>("⬜️");
  public static final Config<String> Tile_Number =
      new Config("0️⃣1️⃣2️⃣3️⃣4️⃣5️⃣6️⃣7️⃣8️⃣9️⃣🔟*️⃣");
  public static final Config<String> Tile_MoveMark =
      new Config<>("⚪️⚫️🔲⬜️⏪️◀️⏸️▶️⏩️⬆️↗️➡️↘️⬇️↙️⬅️↖️");
  public static final Config<String> Tile_HanPiece =
      new Config<>("🫅👨‍✈️👨‍🚒👨‍🚀👨‍⚖️👨‍🎓👨‍🌾");
  public static final Config<String> Tile_ChoPiece =
      new Config<>("👸👮‍♀️👩‍🚒👩‍🚀👩‍⚖️👩‍🎓👩‍🌾");
      
      public static final String turn_on ="✅️";
      public final String turn_off="☑️";
      public final String background ="⬜️";
      public final String background_layer ="⬛";
      public final String move_make ="🔳";
      public final String move_make2 ="❌️";
      public final String move_make3 ="❎️";
      public static final String life = "❤️";
      public static final String life2 = "🖤";
      
}
