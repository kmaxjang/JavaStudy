package com.game.worm;

public class Land implements Schedule{

	public enum LandMark {
		WALL(-1), SPACE(0), WORM_HEAD(1), WORM_BADY(2), FRUTE(3);
		private int value;

		private LandMark(int value) {
			this.value = value;
		}

		public int getVelue() {
			return value;
		}
	}

	private int size = 10;
	private int size_x = size;
	private int size_y = size;

	private LandMark[][] land = new LandMark[size_x][size_y];

	public Land() {
		setLand();
		food();
	}

public boolean isWork(){
  return true;
}

public void runWork(){
  print();
}
	private Point food_point = new Point();
	public void food() {
		while (true) {
			food_point.x = (int) (Math.random() * size);
			food_point.y = (int) (Math.random() * size);
			if (landCheck(food_point).equals(LandMark.SPACE)) {
				land[food_point.x][food_point.y] = LandMark.FRUTE;
				System.out.println("food[" + food_point.x + "][" + food_point.y
						+ "] = " + landCheck(food_point));
				break;
			}
		}
	}

	public LandMark landCheck(Point p) {
		return land[p.x][p.y];
	}

	private StringBuffer sb = new StringBuffer(size_x * size_y);
	private Point land_point = new Point();
	private int count =0;

	public void print() {
		sb.delete(0, sb.length());
		for (int y = 0; y < size_y; y++) {
			for (int x = 0; x < size_x; x++) {
				land_point.set(x, y);
				switch (landCheck(land_point)) {
					case SPACE :
						sb.append("◼");
						break;
					case FRUTE :
						sb.append("🍎");
						break;
					case WORM_HEAD :
						sb.append("😀");
						break;
					case WORM_BADY :
						sb.append("🌕");
						break;
					default :
						sb.append(" ");
						break;
				}
			}
			sb.append("\n");
		}
		System.out.println("Worm move count : "+count+"\n" + sb);
		count++;
	}

	public boolean addWorm(Worm worm) {

		return false;
	}

	private void setLand() {
		for (int x = 0; x < size_x; x++) {
			for (int y = 0; y < size_y; y++) {
				if (x == 0 || x == size_x - 1 || y == 0 || y == size_y - 1) {
					land[x][y] = LandMark.WALL;
				} else {
					land[x][y] = LandMark.SPACE;
				}
			}
		}
	}
}
