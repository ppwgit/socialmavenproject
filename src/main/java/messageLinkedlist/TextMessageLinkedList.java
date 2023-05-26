package messageLinkedlist;

import message.Message;

public class TextMessageLinkedList<T extends Message> {
	private Node<T> head;
	private int size;

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	public TextMessageLinkedList() {
		head = null;
		size = 0;
	}

	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	public void add(int index, T data) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> newNode = new Node<T>(data);
		if (index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}

	public int size() {
		return size;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public void addLast(T data) {
		Node<T> newNode = new Node<>(data);

		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	public void addMiddle(T data, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}

		Node<T> newNode = new Node<>(data);

		if (head == null || index == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}
}