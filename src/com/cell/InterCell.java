package com.cell;

public interface InterCell {

    public InterCell link(InterCell link);

    public void signal(int signal);

    public void control(Control control);
}

interface Control {
    public int time();
}
