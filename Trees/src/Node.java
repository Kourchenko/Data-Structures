public class Node {

    int value;
    Node left;
    Node right;

    boolean isPresent;

    Node(int val) {
        value = val;
        left = null;
        right = null;
        isPresent = true;
    }

    public void setValue(int val) {
        value = val;

    }

    public void setLeft(Node node) {
        left = node;

    }

    public void setRight(Node node) {
        right = node;

    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;

    }

    public Node getRight() {
        return right;

    }

    public boolean isPresent() {
        return isPresent;

    }

    public boolean setNotPresent() {
        isPresent = false;

        return true;

    }

    public boolean setPresent() {
        isPresent = true;

        return true;
    }


}
