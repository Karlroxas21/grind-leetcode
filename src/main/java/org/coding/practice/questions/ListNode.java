package org.coding.practice.questions;

public class ListNode {
    // Data stored in this node
    public int data;

    // Reference to the next code in the list.
    // If this is the last node, 'next' will be null.
    public ListNode next;

    // Constructor to create a new node with data
    public ListNode(int data) {
        this.data = data;
        this.next = null; // Initially, a new node doesn't point to anything.
    }

    public ListNode(){}

}

class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    // Constructor to initialize an empty linked List
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Basic Operations

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the list has no nodes, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the number of element in the linked list.
     *
     * @return The current size of the list.
     */
    public int size() {
        return size;
    }

    // Adding Elements

    /**
     * Adds a new node with the given data to the end of the list.
     * O(1) time complexity if 'tail' ins maintained.
     *
     * @param data the data to add.
     */
    public void add(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode; // If first node, it's also the tail
        } else {
            tail.next = newNode; // Link the current tail to the new node
            tail = newNode; // Update the tail to be the new node.
        }
        size++;
    }

    /**
     * Adds a new node with the given data to the beginning of the list.
     * O(1) time complexity.
     *
     * @param data the data to add.
     */
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // new node points to the current head
            head = newNode;
        }
        size++;
    }

    /**
     * Inserts a new node with the given data at a specific index.
     * O(N) time complexity in the worst case (inserting in the middle or end)
     *
     * @param index the index at which to insert the new node (0-based)>
     * @param data  the data to insert.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            add(data);
        } else {
            ListNode newNode = new ListNode(data);
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next; // Travers to the node *before* the insertion point
            }
            newNode.next = current.next; // New node points to the node that was at 'index'
            current.next = newNode; // The previous node now points to the new node
            size++;
        }
    }

    // Retrieving Elements

    /**
     * Returns the data of the node at the specified index.
     * O(N) time complexity in the worst case.
     *
     * @param index The index of the node to retrieve (0-based).
     * @return The data at the specific index.
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next; // Traverse to the desired node
        }
        return current.data;
    }

    /**
     * Returns the data of the first node in the list.
     * O(1) time complexity.
     *
     * @return The data of the first node.
     * @throws IllegalStateException if the list is empty.
     */
    public int getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    /**
     * Returns the data of the last node in the list.
     * O(1) time complexity if 'tail' is maintained. O(N) otherwise.
     *
     * @return The data of the last node.
     * @throws IllegalStateException if the list is empty.
     */
    public int getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
        return tail.data;
    }

    // Removing Elements

    /**
     * Removes the first node from the list.
     * O(1) time complexity.
     *
     * @return The data of the removed node.
     * @throws IllegalStateException if the list is empty.
     */
    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
        int removedData = head.data;
        head = head.next; // Head moves to the next node
        if (head == null) { // If the list becomes empty after removal
            tail = null;
        }
        size--;

        return removedData;
    }

    /**
     * Removes the last node from the list.
     * O(N) time complexity (requires traversing to the second-to-last node).
     *
     * @return The data of the removed node.
     * @throws IllegalStateException if the list is empty.
     */
    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (size == 1) { // Special case: only one node.
            int removedData = head.data;
            head = null;
            tail = null;
            size--;
            return removedData;
        }

        ListNode current = head;
        // Traverse to the second-to-last node
        while (current.next != tail) {
            current = current.next;
        }
        int removedData = tail.data;
        current.next = null; // The second-to-last node now becomes the new tail
        tail = current;
        size--;
        return removedData;
    }

    /**
     * Removes the node at the specified index.
     * O(N) time complexity.
     *
     * @param index The index of the node to remove (0-based).
     * @return The data of the removed node.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public int removeAt(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            removeFirst();
        }

        if (index == size - 1) {
            removeLast();
        }

        ListNode current = head;
        // Traverse to the node *before* the node to be removed
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        int removedData = current.next.data; // Data of the node to be removed
        current.next = current.next.next; // Skip the node to be removed
        size--;

        return removedData;
    }


    /**
     * Removes the first occurrence of a node with the given data.
     * O(N) time complexity.
     *
     * @param data The data to remove.
     * @return true if the data was found and removed, false otherwise.
     */
    public boolean removeFirstOccurrence(int data) {
        if (isEmpty()) return false;

        // Case 1: The head contains the data
        if (head.data == data) {
            head = head.next;
            if (head == null) { // List had only one element
                tail = null;
            }
            size--;
            return true;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                // if we're removing the tail, update the tail pointer.
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Traversing LinkedList

    /**
     * Convert Array to LinkedList
     */
}