package com.jjanggi2;
import java.awt.Point;
import java.util.List;

public interface Chess {

	public enum type {KG, JU, SA, SN, MA, PO, CH};
	public boolean isTeams();
	public Chess.type getType();
	public Point getNowPosition();
	public void setPosition(Point position);
	public List<Point> getMoveList();
}
