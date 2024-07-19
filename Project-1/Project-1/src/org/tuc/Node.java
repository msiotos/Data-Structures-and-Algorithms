package org.tuc;

public class Node {
	
	private Element element;
	//private Node head;
	private Node next;
	//private Node tail;
	

	public Node(Element element) {
		this.element = element;
		this.next = null;
	}
	
	public Element getElement() {
		return element;
	}
	
	public void setElement(Element element) {
		this.element = element;
	}
	
	/*public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
*/
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
/*	
	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}
	
*/
}
