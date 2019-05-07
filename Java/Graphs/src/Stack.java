class Stack {

    /* Instance Variables */
    private final int SIZE = 20;
    int[] theStack;
    int top;

    Stack() {
        theStack = new int[SIZE];
        top = -1;

    }

    public void push(int j) {
        theStack[++top] = j;
    }

    public int pop() {
        return theStack[top--];
    }

    public int peek() {
        return theStack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        Stack n = new Stack();

        n.push(1);
        n.push(3);
        n.push(5);

        while (!n.isEmpty()) {
            System.out.println(n.pop());
        }
    }

} // Class Stack
