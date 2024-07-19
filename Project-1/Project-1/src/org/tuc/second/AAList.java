package org.tuc.second;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.tests.MultiCounter;

public class AAList implements List {
	private Element[] e;
	private int[] p;
	private int head;
	private int tail;
	private int nextfree;

	public AAList(int N) { 
		e = new Element[N];
		p = new int[N];
		for (int i = 0; i < N - 1; i++) {
	        p[i] = i + 1;
	    }
	    p[N - 1] = -1;
	    head = -1;
	    tail = -1;
	    nextfree = 0;
	}
	@Override
	public boolean insert(Element element) {
		
		MultiCounter.increaseCounter(6, 1);
		if (nextfree == -1) {
			
			return false;
			}
		int n = nextfree;
		
		//Update nextfree 
		nextfree = p[nextfree];
	
		

		e[n] = element;
		p[n] = -1;
		
		MultiCounter.increaseCounter(6, 5);
		if(tail != -1) { //If the list isn't empty case
			MultiCounter.increaseCounter(6, 1);
			p[tail] = n;
		} else { //If the list is empty case
			head = n;
			MultiCounter.increaseCounter(6, 2);
		}
		//Update the tail
		tail = n;
		MultiCounter.increaseCounter(6, 1);

		return true;
	}
	@Override
	public boolean delete(int key) {
		MultiCounter.increaseCounter(8, 2);
		int prevNode = -1;
		for (int currentNode = head; currentNode != -1; currentNode = p[currentNode]) { //Traverse the list
			MultiCounter.increaseCounter(8, 1);
			if (e[currentNode].getKey() == key) { //If the element is found
				MultiCounter.increaseCounter(8, 1);
				if (prevNode == -1) { //If the element is head case
					head = p[currentNode];
					MultiCounter.increaseCounter(8, 2);
				} else {
					p[prevNode] = p[currentNode];
					MultiCounter.increaseCounter(8, 2);
					
				}
				if (tail == currentNode) { //If the element is tail case
					tail = prevNode;
					MultiCounter.increaseCounter(8, 2);
					
				}
				e[currentNode] = null;
				p[currentNode] = nextfree;
				nextfree = currentNode;
				MultiCounter.increaseCounter(8, 3);
				return true;
			}
			prevNode = currentNode;
			MultiCounter.increaseCounter(8, 2);
		}
		return false;
	}

	@Override
	
	public Element search(int key) {
	    for (int currentNode = head; currentNode != -1; currentNode = p[currentNode]) { //Traverse the list
	    	MultiCounter.increaseCounter(7, 1);
	        if (e[currentNode].getKey() == key) { //If the element is found 
	            return e[currentNode];
	        }
	        MultiCounter.increaseCounter(7, 1);
	    }
	    return null;
	}

}
