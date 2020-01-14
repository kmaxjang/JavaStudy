package com.sample.binary;

public class TreeKind {

	private int this_number;
	
	private TreeKind root = null;
	private TreeKind low = null;
	private TreeKind hight = null;
	
	private int level =0;
	
	// 생성자
	public TreeKind(int number, TreeKind root, int level) {
		this.root = root;
		this.this_number = number;
		this.level =level;
	}
	
	// 자신의 번호
	public int getNumber() {
		return this_number;
	}
	
	// 더해진 번호 나무가지
	public TreeKind addKind(int addnumber) {
		if(this_number < addnumber) {
			if(hight == null) {
				hight = new TreeKind(addnumber, this, level+1);
			}else {
				hight.addKind(addnumber);
			}
		}else if(this_number > addnumber){
			if(low == null) {
				low = new TreeKind(addnumber, this, level+1);
			}else {
				 low.addKind(addnumber);					
			}			
		}
		return root;
	}
	
	public void insert(TreeKind insert, boolean lh) {
		if(lh) {
			hight = insert;
		}else {
			low = insert;
		}
		level++;
	}
	
	public void getPrint() {
		System.out.printf("[Lv%d( %1d )]>",level,this_number);
		if(hight == null) {
			System.out.println();			
		}else {
//			System.out.print("H");
			hight.getPrint();
		}
		if(low == null) {
			if(hight != null)
				System.out.println();			
		}else {			
			for(int c=0; c< level; c++) {
				System.out.print("|          ");
			}
			System.out.print("|---------");
//			System.out.print("L");
			low.getPrint();
		}
	}
	
}
