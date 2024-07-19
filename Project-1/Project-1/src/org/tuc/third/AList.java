package org.tuc.third;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.tests.MultiCounter;


public class AList implements List{
	
	protected Element[] elements; //Array to store elements
	protected int tail; //Variable to keep track of the last element of the list
	
	
	//Constructor to initialize the list
	public AList(int listsize) {
		elements = new Element[listsize];
		tail = 0;
	}

	
	//Insert class used to insert an element at the end of the list
	@Override
	public boolean insert(Element element) {
		//If the list is empty case
		MultiCounter.increaseCounter(12, 1);
		if(tail == elements.length) {
			return false;
		}
		//If not empty insert the element at the tail index and increment it by one
		elements[tail++] = element;
		MultiCounter.increaseCounter(12, 1);
		return true;
		
		
	}
	
	@Override
	public boolean delete(int key) {
		// TODO Auto-generated method stub
		int i = 0;
		
		MultiCounter.increaseCounter(14, 2);
		
		while(i< tail && elements[i].getKey()!=key ) { //Search for the element with the given key 
			i++;
			MultiCounter.increaseCounter(14, 1);
		}
		MultiCounter.increaseCounter(14, 1);
		if (i == tail) { 
			return false;
		}
		MultiCounter.increaseCounter(14, 1);
		for (int j = i + 1; j < tail; j++) { //Shift to the left to remove the element 
			elements[j - 1] = elements[j];
			MultiCounter.increaseCounter(14, 2);
		}
		//Set last element to null and decrement tail by one
		elements[tail - 1] = null;
		MultiCounter.increaseCounter(14, 1);
		
		tail--;
		return true;
	}

	@Override
	public Element search(int key) {
		
		MultiCounter.increaseCounter(13, 1);
		for (int i = 0; i < tail; i++) { //Traverse the list to find the element with the given key 
			MultiCounter.increaseCounter(13, 1);
			if(elements[i].getKey() == key) {
				return elements[i];
			}
			MultiCounter.increaseCounter(13, 1);
		}
		return null;
		
		
	}
	


}
