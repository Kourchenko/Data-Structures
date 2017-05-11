public class Node {

    String value;
    Node left;
    Node right;

    // IF lots of add
    // few deletes
    // int value is now non-existent
    boolean present;

    // If lots of delete
    // Code better solution

    Node(String val) {
        value = val;
        left = null;
        right = null;

    }

    public void setValue(String val) {
        value = val;
    }

    public String getValue() {
        return value;
    }

    public void setLeft(Node node) {
        left = node;
    }

    public void setRight(Node node) {
        right = node;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
