package com.ex07;

import java.util.List;

public enum DequeMode {
  Queue {
    public <T> T output(List<T> data) {
      return data.isEmpty() ? null : data.remove(0);
    }

    public <T> T peek(List<T> data) {
      return data.isEmpty() ? null : data.get(0);
    }
  },
  Stack {
    public <T> T output(List<T> data) {
      return data.isEmpty() ? null : data.remove(data.size() - 1);
    }

    public <T> T peek(List<T> data) {
      return data.isEmpty() ? null : data.get(data.size() - 1);
    }
  };

  public abstract <T> T output(List<T> data);

  public abstract <T> T peek(List<T> data);
}
