package com.fps;

public class FPS {

	private boolean end = false;
	
	private FpsDelayer delayer = new FpsDelayer(100);

	private long strattime =0;
	private long endtime =0;
	private long difftime =0;
	
	private long frame_count = 0;
	
	public FPS() {
		run();
	}
	
// Game loop	
	public void run() {
		while(!end) {
			strattime =	System.currentTimeMillis();
			update();
			drawing();
			endtime = System.currentTimeMillis();
			difftime = endtime - strattime ;
			
			delayer.delay(difftime);
			Frame.count();
			if(frame_count >1000) {
				end = true;
			}
		}
	}
	
	// ��ǥ�̵�, ��ġ�������� ���� ���� ����	
	
	public void update() {
		frame_count++;
		 
	    int delay = (int)(Math.random() * 10) + 10; // 0.5�� ~ 3�� ��ŭ ������ �����̸� �ش�.
	    try{
	        Thread.sleep(delay);  // CPU ������ delay ��ŭ �����ϴ� �޼���
	    }catch(Exception e){}
	}
	
	// ȭ�鿡 �ð������� �׸��� �۾�
	public void drawing() {
		 System.out.println("FrameCount : "+ frame_count);
		 System.out.println("FrameTime :"+ difftime + "ms");
		 System.out.println(Frame.getFps()+ " FPS");
	}
	
	public static void main(String[] args) {
		new FPS();
	}

}

/* 
*  ���ڷ� ��ǥ�ϴ� FPS ���� �ް�
*  delay�޼��忡 ����ð��� ���ö�����
*  ��ǥ�� FPS���� �ǵ��� ��� �����.
*/ 
class FpsDelayer{
    private long TARGET_FPS; // ��ǥ FPS
    private long MSPF =0; // Milli Second Per Frame
    
    FpsDelayer(long targetFps){
        TARGET_FPS = targetFps;  // ��ǥ�� FPS�� ���߱� ���� �� �����ӿ� �� �и��ʰ� �ʿ����� ����Ѵ�.
        MSPF = Math.round(1000.0/TARGET_FPS);  // ������� 30FPS�� ���Ѵٸ� 1000ms / 30Frame = 33 ms/Frame �� �ȴ�.
    }
    
    void delay(long operatingTime){
    // �̹� ������ ����ð��� ������ ��ǥ FPS���� ���߾� �������� ������Ų��.
        if(operatingTime >= MSPF){ // ��, ����ð��� �ʹ� ����ٸ� ��ü���� ������.
            return;
        }else{
            try{
                Thread.sleep( MSPF - operatingTime );
            }catch(Exception e){}
        }   
    }  
}

/*
* ���� FPS���� üũ�ϴ� �ڵ�
* count()�� ȣ��ɶ����� ī���� �ϴٰ�
* 1�ʰ� ������ ����� ī���� �ߴ��� ����Ѵ�.
*/
 class Frame{
    private static long lastTime = System.currentTimeMillis();
    private static long nowTime=0;
    private static long diffTime=0;
    // lastTime�� ���� �ð��Դϴ�.
    // ó�� ��������� �ð��� �������� �� ���� 1�ʰ� ���������� ���ŵ˴ϴ�.
    private static long frameCount = 0, nowFps = 0;
    // frameCount�� �����Ӹ��� ���ŵǴ� ���Դϴ�.
    // nowFps�� 1�ʸ��� ���ŵǴ� ���Դϴ�.
     
    public static void count(){
        nowTime = System.currentTimeMillis();
        diffTime = nowTime - lastTime;  // ���ؽð� ���κ��� �� �ʰ� �������� ����մϴ�.
 
        if (diffTime >= 1000) { // ���� �ð����� ���� 1�ʰ� �����ٸ�
            nowFps = frameCount;
            frameCount = 0;  // nowFps�� �����ϰ� ī������ 0���� �ٽ��մϴ�.
            lastTime = nowTime; // 1�ʰ� �������Ƿ� ���� �ð����� �����մϴ�.
        }else {
        	frameCount++;  // ���� �ð����� ���� 1�ʰ� �������ٸ� ī��Ʈ�� 1 �ø��� �ѱ�ϴ�.        	
        }
    }
    
    public static long getFps(){
    	
        return nowFps;
    }
}