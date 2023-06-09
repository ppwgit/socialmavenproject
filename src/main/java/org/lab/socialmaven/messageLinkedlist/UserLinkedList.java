package org.lab.socialmaven.messageLinkedlist;

public class UserLinkedList <T>  {

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

public void addLast(T data) {
    Node<T> newNode = new Node<>(data);

    if (head == null) {
        head = newNode;
    } else {
        Node<T> currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    size++;
}

public void addMiddle(T data, int position) {
    if (position < 0 || position > size) {
        throw new IndexOutOfBoundsException("Invalid position: " + position);
    }

    Node<T> newNode = new Node<>(data);

    if (head == null) {
        head = newNode;
    } else if (position == 0) {
        newNode.next = head;
        head = newNode;
    } else {
        Node<T> currentNode = head;
        int currentPosition = 0;

        while (currentPosition < position - 1) {
            currentNode = currentNode.next;
            currentPosition++;
        }

        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    size++;
}

@Override
public String toString() {
    StringBuilder result = new StringBuilder("[ ");

    Node<T> currentNode = head;

    while (currentNode != null) {
        result.append(currentNode.data.toString()).append(" ");
        currentNode = currentNode.next;
    }

    result.append("]");

    return result.toString();
}




// create Printing the list?

}
