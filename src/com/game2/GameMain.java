package com.game2;
import java.awt.Container;

import javax.swing.JFrame;

public class GameMain {
		
	private JFrame window = new JFrame();
	private String title = "DragonLotto";
	
	public GameMain(Container contentPane) {		
		window.setContentPane(contentPane);
		setWindow();
	}
	
	public void setWindow(){
		window.setTitle(title);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);		
	}

	public static void main(String[] args){
		new GameMain(new GamePanel());		
	}
	
}


