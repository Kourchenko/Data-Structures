
public class Node {

    private Node next;
    private int value;


    Node(int n) {
        value = n;
        next = null;

    }

    public boolean addNode(Node node) {

        next = node;

        return true;

    }

    public int getValue() {
        return this.value;

    }

    public Node getNext() {
        return next;
    }


    public static void main(String[] args) {

        Node node1 = new Node(1);

        Node node2 = new Node(2);
        node2.addNode(node1);

        Node node3 = new Node(3);
        node3.addNode(node2);


        System.out.println(node2.next.value);
        System.out.println(node3.next.value);
        System.out.println(node3.value);


    }



}
