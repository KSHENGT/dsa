/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adt;

/**
 *
 * @author jians
 */
import java.io.Serializable;
import java.util.Iterator;
import java.lang.Iterable;

/**
 *
 * @author jians
 * @param <T>
 */
///helllo testinggggg
public class DoublyLinkedList<T> implements ListInterface<T>, Serializable,Iterable<T> {

    private Node firstNode;
    private int numberOfEntries;

    public DoublyLinkedList() {
        clear();
    }

    @Override
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } 
        else {
            Node currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.prev = currentNode;
        }
        numberOfEntries++;
        return true;
    }
    
    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        
        if ((newPosition >= 1) && (newPosition <= numberOfEntries)) {
            Node newNode = new Node(newEntry);
            
            if (isEmpty()) {
                firstNode = newNode;
            }
            else if (newPosition == 1) {
                firstNode.prev = newNode;
                newNode.next = firstNode;
                firstNode = newNode;
            }
            else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
                }
                
                newNode.next = nodeBefore.next;
                newNode.prev = nodeBefore;
                nodeBefore.next.prev = newNode;
                nodeBefore.next = newNode;
            }
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }
    
    @Override
    public T remove(int givenPosition) {
        T result = null;

        if (givenPosition >= 1 && givenPosition <= numberOfEntries) {
            if (givenPosition == 1) { // Removing first node
                result = firstNode.data;
                if (firstNode.next != null) {
                    firstNode.next.prev = null;
                }
                firstNode = firstNode.next;
            } else {
                Node nodeBefore = firstNode;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }

                Node nodeToRemove = nodeBefore.next;
                result = nodeToRemove.data;
                nodeBefore.next = nodeToRemove.next;

                if (nodeToRemove.next != null) { // Check before setting prev
                    nodeToRemove.next.prev = nodeBefore;
                }
            }
            numberOfEntries--;
        }
        return result;
    }
    
    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0;i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
            currentNode.data = newEntry;
        }
        else {
            isSuccessful = false;
        }
        return isSuccessful;
    }
    
    @Override
    public T getEntry(int givenPosition) {
        T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 0; i < givenPosition - 1; ++i) {
                currentNode = currentNode.next;
            }
        result = currentNode.data;
        } 
        return result;
    }
    
    @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } 
            else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }
    
    @Override
    public T getFront() {
        T result = null;
        if (!isEmpty()) {
            result = firstNode.data;
        }
        return result;
    }
    
    @Override
    public final void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder outputStr = new StringBuilder();
        Node currentNode = firstNode;
        while (currentNode != null) {
            outputStr.append(currentNode.data).append("\n");
            currentNode = currentNode.next;
        }
        return outputStr.toString();
    }
    
    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator();
    }

    
    private class LinkedQueueIterator implements Iterator<T> {

        private Node currentNode;

        public LinkedQueueIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T returnData = currentNode.data;
                currentNode = currentNode.next;
                return returnData;
           } 
           else {
                throw new java.util.NoSuchElementException();
           }
        }
        
        
    }
    
    // Inner class for Node
    private class Node {

        private T data;
        private Node next;
        private Node prev;

        private Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        private Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}
