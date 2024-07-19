package org.tuc.first;

import org.tuc.Element;
import org.tuc.Node;
import org.tuc.tests.MultiCounter;

public class SDList extends DList {
	
	
	public SDList() {
		super();
	}

	@Override
	public boolean insert(Element element) {
		// TODO Auto-generated method stub
		
		MultiCounter.increaseCounter(3,2);
		Node newNode = new Node(element);
		if(head == null) { //If the list is empty case
			
			head = newNode;
			tail = newNode;
			MultiCounter.increaseCounter(3, 2);
			
		} else { //If the list isn't empty case 
			
			Node current = head;
			MultiCounter.increaseCounter(3, 3);
			if (element.getKey() <= head.getElement().getKey()) { //Element inserted before head
				newNode.setNext(head);
				head = newNode;
				MultiCounter.increaseCounter(3, 3);
			} else if (element.getKey() >= tail.getElement().getKey()) { //Element inserted after tail
				
				tail.setNext(newNode);
				tail = newNode;	
				MultiCounter.increaseCounter(3, 2);
				
			}
			else { //Element inserted between head and tail
				
					MultiCounter.increaseCounter(3,2);
					while(current.getNext() != null && current.getNext().getElement().getKey() < element.getKey()) {
						current = current.getNext();
						MultiCounter.increaseCounter(3, 2);
					}
					
					newNode.setNext(current.getNext()); 
					current.setNext(newNode);
					MultiCounter.increaseCounter(3, 2);
				}
			}
		
		return true;
			
		}
		
				
		
		
	

	@Override
	public boolean delete(int key) {
		// TODO Auto-generated method stub
		
		
		MultiCounter.increaseCounter(5, 1);
		if (head == null) {
			return false;
		} 
		//If the element is at the start of the list delete it
		
		MultiCounter.increaseCounter(5, 1);
		if (head.getElement().getKey()==key) {
			head = head.getNext();
			MultiCounter.increaseCounter(5, 1);
			return true;
		}
		
		//If not search for the first time it appears on the list starting from the beginning
		
		MultiCounter.increaseCounter(5, 1);
		Node current = head;
		while(current.getNext() != null) {
			MultiCounter.increaseCounter(5, 1);
			if ( current.getNext().getElement().getKey() == key) {
				current.setNext(current.getNext().getNext()); //NOT SURE ABOUT THIS LINE
				MultiCounter.increaseCounter(5, 1); //maybe wrong?
				return true;
			}
			current = current.getNext();
			MultiCounter.increaseCounter(5, 2);
		}
		
		return false;
	}

	@Override
	public Element search(int key) {
		// TODO Auto-generated method stub
		
		MultiCounter.increaseCounter(4, 1);
		Node current = head;
		while(current != null) {
			MultiCounter.increaseCounter(4, 1);
			if (current.getElement().getKey()==key) {
				return current.getElement();
			}
			current = current.getNext();
			MultiCounter.increaseCounter(4, 2);
		}
		
		return null;
	}
	
	

}
