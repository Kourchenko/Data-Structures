/**
 * Created by diegok on 4/25/17.
 */
class myStructList {
    Link head;
    Link tail;

    public myStructList() {
        head = null;
    }

    void addHead(int value) {
        Link newLink = new Link(value);
        Link tmp = head;
        head = newLink;
        newLink.next = tmp;
    }

    void addTail(int value) {}

    int removeHead() {
        if (head != null) {
            return head.value;
        }
        return head.value;
    };
}
