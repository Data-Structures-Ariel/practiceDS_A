package com.company;

public class pre_05 {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.addFirst(8);
        System.out.println(list);
        list.addFirst(90);
        System.out.println(list);
        System.out.println(list.isEmpty());
        System.out.println(list.contains(4));
        System.out.println(list.contains(40));
        System.out.println(list.get(100));
        System.out.println(list.get(8));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.peek());
    }
}

class LinkedList implements List {
    Node head;
    int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(int d) {
        if (this.head == null)
            this.head = new Node(d, size++);
        else {
            Node new_node = new Node(d, size++);
            Node temp_head = this.head;
            while (temp_head.next != null)
                temp_head = temp_head.next;
            temp_head.next = new_node;
        }
    }

    @Override
    public void addFirst(int data) {
        Node temp = new Node(data, 0);
        if (this.head == null)
            this.head = temp;
        else {

            temp.next = this.head;
            this.head = temp;
            while (temp.next != null) {
                temp.next.index++;
                temp = temp.next;
            }
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(int data) {
        Node temp_head = this.head;
        while (temp_head != null && temp_head.data != data)
            temp_head = temp_head.next;
        return temp_head != null ? temp_head.data == data : false;
    }

    public int get(int index) {
        if (isEmpty() || index < 0 || index >= this.size)
            return Integer.MAX_VALUE;
        Node temp_head = this.head;
        while (temp_head != null && temp_head.index != index)
            temp_head = temp_head.next;
        return temp_head != null ? temp_head.data : Integer.MAX_VALUE;
    }

    @Override
    public int getFirst() {
        return this.head.data;
    }

    @Override
    public int getLast() {
        Node temp_head = this.head;
        while (temp_head.next != null)
            temp_head = temp_head.next;
        return temp_head.data;
    }

    @Override
    public int peek() {
        return this.head.data;
    }

    @Override
    public String toString() {
        if (this.head == null)
            return "null";
        else {
            Node temp_head = this.head;
            while (temp_head != null) {
                System.out.printf("data = %d, index =%d \n", temp_head.data, temp_head.index);
                temp_head = temp_head.next;
            }
            System.out.println("");
        }
        return "LinkedList{size =" + size + "}";
    }
}

class Node {
    int data;
    Node next;
    int index;

    public Node(int data, int index) {
        this.data = data;
        this.index = index;
    }
}

interface List {
    /**
     * Appends the specified element to the end of this list.
     */
    void add(int data);

    /**
     * Inserts the specified element at the beginning of this list.
     */
    void addFirst(int data);

    boolean isEmpty();

    boolean contains(int data);

    int get(int index);

    int getFirst();

    int getLast();

    int peek();
}
