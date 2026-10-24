package com.ex16;

public interface Link<T> {

void join(Link<T> link);

boolean update();
}
