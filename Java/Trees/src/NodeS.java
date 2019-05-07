public class NodeS {

    /**
     * NodeS for a Tree Data Structure.
     *
     * String value
     */

    private String value;
    private NodeS left;
    private NodeS right;

    NodeS(String val) {
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

    public void setLeft(NodeS node) {
        left = node;
    }

    public void setRight(NodeS node) {
        right = node;
    }

    public NodeS getLeft() {
        return left;
    }

    public NodeS getRight() {
        return right;
    }
}
