package com.example.algo_dat_asgn_2;

import java.io.*;

public class DoublyLinkedList<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    Node<T> head;
    Node<T> tail;

    static class Node<T> implements Serializable {
        private static final long serialVersionUID = 1L;
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    // Insert at the end of the list
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert at the beginning of the list
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insert at a specific position (0 base index)
    public void insertAtPosition(T data, int position) {
        if (position <= 0) {
            insertAtBeginning(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        int count = 0;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            insertAtEnd(data);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
        }
    }

    // Save (binary serialization)
    public void saveListToBinaryFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("List saved to binary file: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving list to binary file: " + e.getMessage());
        }
    }

    // Load (binary serialization)
    public static <T> DoublyLinkedList<T> loadListFromBinaryFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (DoublyLinkedList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading list from binary file: " + e.getMessage());
            return null;
        }
    }

    // Print the list from head to tail
    public void printList() {
        Node<T> currNode = head;
        System.out.print("Doubly Linked List (Head to Tail): ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    // Print the list from tail to head
    public void printListReverse() {
        Node<T> currNode = tail;
        System.out.print("Doubly Linked List (Tail to Head): ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.prev;
        }
        System.out.println();
    }

    // Clear the whole list
    public void clear() {
        head = null;
        tail = null;
        System.out.println("List cleared.");
    }

    // Update node at specific position (0-based index)
    public void updateAtPosition(T newData, int position) {
        if (position < 0) {
            System.err.println("Invalid position.");
            return;
        }

        Node<T> current = head;
        int count = 0;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current != null) {
            current.data = newData;
        } else {
            System.err.println("Position out of bounds.");
        }
    }

    // Count the number of nodes in the list
    public int countNodes() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Remove node at a specific position
    public void removeAtPosition(int position) {
        if (position < 0 || head == null) {
            System.err.println("Invalid position or list is empty.");
            return;
        }

        Node<T> current = head;
        int count = 0;

        while (current != null && count < position) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.err.println("Position out of bounds.");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;  // Update head if at the start
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;  // Update tail if at the end
        }
    }

    // Remove node with specific data
    public void remove(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;  // Update head if at the start
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;  // Update tail if at the end
                }
                break;
            }
            current = current.next;
        }
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

 //   public static void main(String[] args) {
 //       DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
//
//        // Test insertions
//        list.insertAtEnd(1);
//        list.insertAtEnd(3);
//        list.insertAtEnd(4);
//        list.printList();
//
//        list.insertAtBeginning(0);
//        list.printList();
//
//        list.insertAtPosition(2, 2);
//        list.printList();
//
        // Test removals
//        list.removeAtPosition(2);
//        list.printList();
//
 //       list.remove(4);
  //      list.printList();

        // Save the list to a file
//        list.saveListToBinaryFile("doublyLinkedList.bin");

        // Load the list from the file
      //  DoublyLinkedList<Integer> loadedList = DoublyLinkedList.loadListFromBinaryFile("doublyLinkedList.bin");
      //  if (loadedList != null) {
      //      loadedList.printList();
      //  }
  //  }
}
