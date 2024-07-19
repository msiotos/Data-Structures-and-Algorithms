package org.tuc.third;

import org.tuc.Element;
import org.tuc.tests.MultiCounter;

public class SAList extends AList{

	public SAList(int listsize) {
		super(listsize);
	}
	
	@Override
	public boolean insert(Element element) {
	
		MultiCounter.increaseCounter(15, 1);
		if (tail == elements.length) {
			return false;
		}
		MultiCounter.increaseCounter(15, 1);
		int index = binarySearch(element.getKey()); //Find the index using Binary Search
		MultiCounter.increaseCounter(15, 1);
		for (int i = tail -1; i >= index; i--) { //Shift elements to the right side 
			elements[i + 1] = elements[i];
			MultiCounter.increaseCounter(15, 2);
		}
		
		elements[index] = element;
		MultiCounter.increaseCounter(15, 1);
		tail++;
		
		return true;	
		
	}

	@Override
	public boolean delete(int key) {
		
		MultiCounter.increaseCounter(17, 1);
		int index = binarySearch(key); //Find the index using Binary Search
		MultiCounter.increaseCounter(17, 1);
		if (index == tail) {
			return false;
		}
		MultiCounter.increaseCounter(17, 1);
		for ( int i = index +1; i < tail; i++) { //Shift elements to the left side
			elements[i-1] = elements[i];
			MultiCounter.increaseCounter(17, 2);
		}
		//Set last element to null and decrement tail
		elements[tail -1] = null;
		MultiCounter.increaseCounter(17, 1);
		tail--;
		return true;
	}

	@Override
	public Element search(int key) {
		
		MultiCounter.increaseCounter(16, 1);
		int index = binarySearch(key); //Find the index using Binary Search
		MultiCounter.increaseCounter(16, 1);
		if (index == tail) {
			return null;
		}
		
		return elements[index];
	}
	
	//Binary search algorithm
	private int binarySearch(int key) {
		
		int left = 0;
		int right = tail -1;
		MultiCounter.increaseCounter(18, 3);
		
		
		while(left <= right) {
			
			int mid = (left + right) / 2;
			MultiCounter.increaseCounter(18, 2);
			if (elements[mid].getKey() == key) {
				return mid;
			} else if (elements[mid].getKey() < key) {
				left = mid + 1;
				MultiCounter.increaseCounter(18, 2);
			} else {
				right = mid -1;
				MultiCounter.increaseCounter(18, 1);
			}
			MultiCounter.increaseCounter(18, 1);
		}
		
		return right + 1;
	}

}
