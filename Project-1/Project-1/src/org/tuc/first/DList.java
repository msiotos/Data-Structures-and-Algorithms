package org.tuc.first;

import org.tuc.Element;
import org.tuc.List;
import org.tuc.Node;
import org.tuc.tests.MultiCounter;

public class DList implements List {
	
	
	protected Node tail;
	protected Node head;
	
	public DList() { 
		tail = null;
		head = null;
	}

	@Override
	public boolean insert(Element element) {
		
		
		Node newNode = new Node(element); 
		MultiCounter.increaseCounter(0, 2);
		if (head == null) { //If the list is empty set the new node as head and tail
			head = newNode;
			tail = newNode;
			MultiCounter.increaseCounter(0, 2);
		} else { //If it isn't add the new node after the current tail and update the tail
			tail.setNext(newNode);
			tail = newNode;
			MultiCounter.increaseCounter(0, 3);
		}
		
		return true;	
		
	}

	@Override
	public boolean delete(int key) {
		MultiCounter.increaseCounter(2,1);
		if (head == null) { //If the list is empty case
			return false;
		} 
		MultiCounter.increaseCounter(2,1);
		//If the element is at the start of the list delete it
		
		if (head.getElement().getKey()==key) {
			head = head.getNext();
			MultiCounter.increaseCounter(2,2);
			if (head == null) {
				tail = null;
				MultiCounter.increaseCounter(2,1);
			}
			return true;
		}
		//If not search for the first time it appears on the list starting from the beginning
		MultiCounter.increaseCounter(2,2);
		Node current = head;
		while(current.getNext() != null) {
			MultiCounter.increaseCounter(2,1);
			if ( current.getNext().getElement().getKey() == key) {
				current.setNext(current.getNext().getNext());
				MultiCounter.increaseCounter(2,2);
				if (current.getNext() == null) {
					tail = current;
					MultiCounter.increaseCounter(2,1);
				}
				return true;
			}
			current = current.getNext();
			MultiCounter.increaseCounter(2,2);
		}
		return false;
	} 

	@Override
	public Element search(int key) {
		Node current = head;
		MultiCounter.increaseCounter(1,2);
		while(current != null) { //Traverse the list until we find the element with the given key and return it
			MultiCounter.increaseCounter(1, 1);
			if (current.getElement().getKey()==key) {
				return current.getElement();
			}
			current = current.getNext();
			MultiCounter.increaseCounter(1,2);
		}
		return null;
	}
	


}
