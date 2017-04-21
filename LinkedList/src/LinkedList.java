
/*
 * ====================================================================================================================
 * Lab 3
 *
 * Author: Diego Kourchenko
 * Author Date: 2017.04.17
 *
 */


public class LinkedList {
    /*
     * Create a singly linked list
     *
     * Node()
     * - head
     * - tail
     */

    private Node head;
    private Node tail;

    LinkedList() {
        head = null;

    }
    // [2, 3]
    // [ 2, 3, 4, 5 ]

    public void addHead(int value) {
        head = new Node(value);
        tail = head;

    }

    public void addTail(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            tail = new Node(value);
            head.addNode(tail);
            tail = newNode;
        }

        tail.addNode(newNode);
        tail = newNode;

    }

    public int removeHead() {

        Node tmp = new Node(head.getValue());
        int tmpvalue = head.getValue();
        head = tmp;

        return tmpvalue;

    }

    public boolean find(int value) {

        Node next = head;
        while (next != null) {
            if (next.getValue() == value) {

                return true;

            } else {
                next = next.getNext();

            }

        }

        return false;

    }

    public boolean findInsert(int findValue, int insertValue) {

        if (head == null) {
            return false;

        }
        Node found = head;

        while (found != null) {
            if (found.getValue() == findValue) {
                Node tmp = found.getNext();
                Node newNode = new Node(insertValue);
                found.addNode(newNode);
                newNode.addNode(tmp);
                return true;

            } else {
                found = found.getNext();
            }

        }

        return false;

    }

    public boolean findDestroy(int value) {
        Node found = head;

        while (found != null) {
            if (found.getValue() == value) {
                Node tmp = found;
                if (tmp.getNext() != null) {
                    found.addNode(tmp.getNext().getNext());
                    return true;
                } else {
                    head = tmp.getNext();
                    found.addNode(tmp.getNext());
                    return true;
                }

            } else {
                found = found.getNext();
            }
        }
        return false;
    }

    public String listLinks() {

        Node tmp = head;
        String display = "";

        while (tmp != null) {
            display += tmp.getValue() + " ";
            tmp = tmp.getNext();

        }

        return display;

    }

    public static void main(String[] args) {

        Node node = new Node(5);
        Node node2 = new Node(3);

        LinkedList linkedList = new LinkedList();

        linkedList.addHead(2);
        linkedList.addTail(5);
        linkedList.addTail(7);
        linkedList.addTail(9);
        linkedList.addTail(11);

        linkedList.findInsert(7, 20);
        linkedList.findInsert(9, 12);



        System.out.println(linkedList.listLinks());

    }



}
