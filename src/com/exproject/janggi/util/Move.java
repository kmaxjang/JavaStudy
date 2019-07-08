package com.exproject.janggi.util;

// 이동좌표 계산
public enum Move{
    LEFTEUP( -1, -1),
    UP( 0, -1),
    RIGHTUP( 1, -1),
    LEFTE( -1, 0),
    RIGHT( 1, 0),
    LEFTEDOWN( -1, 1),
    DOWN( 0, 1),
    RIGHTDOWN( 1, 1);
    
    private int move_x;
    private int move_y;
    
    public static final int min_x = 0;
    public static final int min_y = 0;
    
    public static final int max_x = 9;
    public static final int max_y = 10;
    
    public static final Point point = new Point(); // 좌표기역
    
    private Move( int x, int y ) {
	move_x = x;
	move_y = y;
    }
    
    // 이동
    public void move(){
	point.x += move_x;
	point.y += move_y;
    }
    
    //이동반복
    public void move( int move ){
	if( move <= 1 ){
	    move();
	}else{
	    for( int a = 0; a < move; a++ ){
		move();
	    }
	}
    }
    
    //최대최소치 판정
    public boolean scope(){
	switch( this ){
	    case LEFTEUP :
		return(Move.LEFTE.scope() && Move.UP.scope());
	    case UP :
		return(point.y >= min_y);
	    case RIGHTUP :
		return(Move.RIGHT.scope() && Move.UP.scope());
	    case LEFTE :
		return(point.x >= min_y);
	    case RIGHT :
		return(point.x < max_x);
	    case LEFTEDOWN :
		return(Move.LEFTE.scope() && Move.DOWN.scope());
	    case DOWN :
		return(point.y < max_y);
	    case RIGHTDOWN :		
		return(Move.RIGHT.scope() && Move.DOWN.scope());
	}
	return false;
    }
}
