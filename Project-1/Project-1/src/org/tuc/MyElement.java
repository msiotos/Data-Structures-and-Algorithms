package org.tuc;

public class MyElement implements Element{
	
	private int key;
	
	public MyElement(int key) {
		this.key = key;
	}

	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return key;
	}

}
