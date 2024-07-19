package org.tuc.second;

import org.tuc.Element;
import org.tuc.tests.MultiCounter;

	public class SAAList extends AAList {
		private Element[] e;
		private int[] p;
		private int head;
		private int tail;
		private int nextfree;

		public SAAList(int N) { 
			super(N);
			e = new Element[N];
			p = new int[N];
			for (int i = 0; i < N - 1; i++) {
		        p[i] = i + 1;
		    }
		    p[N - 1] = -1;
			head = -1;
			tail = -1;
			nextfree=0;
		}
		@Override
		public boolean insert(Element element) {
			MultiCounter.increaseCounter(9, 1);

			if (nextfree == -1) {
				

				return false;
			}
			int n = nextfree;
		    

			nextfree = p[nextfree]; //Update nextfree 
		    

			e[n] = element;
			p[n] = -1;
			MultiCounter.increaseCounter(9, 5);
			if (head == -1) { //If the list is empty case
				head = n;
				tail = n;
				MultiCounter.increaseCounter(9, 2);
			} else {
				int currentNode = head;
				int prevNode = -1;
				MultiCounter.increaseCounter(9, 4);
				while (currentNode != -1 && e[currentNode].getKey() < element.getKey()) { // Find the correct position to insert the element and keep the order
		            
					prevNode = currentNode;
					currentNode = p[currentNode];
					MultiCounter.increaseCounter(9, 3);
				}
				MultiCounter.increaseCounter(9, 1);
				if (prevNode == -1) { //Element inserted at the beginning
					p[n] = head;
					head = n;
					MultiCounter.increaseCounter(9, 2);
				} else { //Element inserted in between
					p[n] = p[prevNode];
					p[prevNode] = n;
					MultiCounter.increaseCounter(9, 4);
					 if (currentNode == -1) {
				            tail = n;
				            p[n] = -1;
				            MultiCounter.increaseCounter(9, 2);
				        } else {
				            p[n] = currentNode;
				            MultiCounter.increaseCounter(9, 2);
				        }
				}
			}
		    

			return true;
		}

		@Override
		public boolean delete(int key) {
			int prevNode = -1;
			MultiCounter.increaseCounter(11, 2);
			for (int currentNode = head; currentNode != -1; currentNode = p[currentNode]) { //Traverse the list
				MultiCounter.increaseCounter(11, 1);
				if (e[currentNode].getKey() == key) {
					MultiCounter.increaseCounter(11, 1);
					if (prevNode == -1) { //If the element is the head case
						head = p[currentNode];
						MultiCounter.increaseCounter(11, 1);
					} else { //If the element is not the head update pointers of the previous node
						p[prevNode] = p[currentNode];
						MultiCounter.increaseCounter(11, 2);
					}
					MultiCounter.increaseCounter(11, 1);
					if (tail == currentNode) { //If the element is the tail case
						tail = prevNode;
						MultiCounter.increaseCounter(11, 1);
					}
					e[currentNode] = null;
					p[currentNode] = nextfree;
					nextfree = currentNode;
					MultiCounter.increaseCounter(11, 3);
					return true;
				}
				prevNode = currentNode;
				MultiCounter.increaseCounter(11, 2);
			}
			return false;
		}

		@Override
		public Element search(int key) {
			MultiCounter.increaseCounter(10, 1);
			for (int currentNode = head; currentNode != -1; currentNode = p[currentNode]) {  //Traverse the list
				MultiCounter.increaseCounter(10, 1);
				if (e[currentNode].getKey() == key) {
					return e[currentNode];
				}
				MultiCounter.increaseCounter(10, 1);
			}
			return null;
		}
		
	}
