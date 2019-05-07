public class TestClass {

    public static void main(String[] args) {

        int lineCount = 0;
        int countPerLine = 7;

        System.out.println("testing double ended queue");
        System.out.println("first as fifo from each side\n");

        Deque aQ = new Deque(9);

        System.out.println("first add left, get left");
        aQ.insertLeft(1);
        aQ.insertLeft(2);
        aQ.insertLeft(3);

        System.out.print(" last, sb 3 = " + aQ.removeLeft() + " ");
        System.out.print(" next, sb 2 = " + aQ.removeLeft() + " ");
        System.out.print(" last, sb 1 = " + aQ.removeLeft() + " \n\n");

        System.out.println("next add right, get right");

        aQ.insertRight(6);
        aQ.insertRight(7);
        aQ.insertRight(8);

        System.out.print(" last, sb 8 = " + aQ.removeRight() + " ");
        System.out.print(" next, sb 7 = " + aQ.removeRight() + " ");
        System.out.print(" last, sb 6 = " + aQ.removeRight() + " \n");

        System.out.println("next as lifo from each side\n");

        Deque bQ = new Deque(9);

        System.out.println("first add left, get right");
        bQ.insertLeft(1);
        bQ.insertLeft(2);
        bQ.insertLeft(3);

        System.out.print(" first, sb 1 = " + bQ.removeRight() + " ");
        System.out.print(" next, sb 2 = " + bQ.removeRight() + " ");
        System.out.print(" last, sb 3 = " + bQ.removeRight() + " \n\n");

        System.out.println("now add right, get left");

        bQ.insertRight(6);
        bQ.insertRight(7);
        bQ.insertRight(8);

        System.out.println(bQ.curElems());

        System.out.print(" first, sb 6 = " + bQ.removeLeft() + " ");
        System.out.print(" next, sb 7 = " + bQ.removeLeft() + " ");
        System.out.print(" last, sb 8 = " + bQ.removeLeft() + " \n");


        /*
         * TEST listing display of elements
         */

        System.out.println("\nnow testing list functions\n");

        aQ = new Deque(9);

        aQ.insertLeft(99);
        aQ.insertRight(43);
        aQ.insertLeft(34);
        aQ.insertRight(47);

        System.out.println("array is " + aQ.curElems());
        System.out.println("listing left to right " + aQ.leftElems());
        System.out.println("listing right to left " + aQ.rightElems());


        /*
         * TEST STACK
         */
        System.out.println("\n\nnow testing stack\n");
        Stack myStack = new Stack(10);

        myStack.push(6);
        myStack.push(7);

        System.out.print(" first peek, sb 7 = " + myStack.peek());
        System.out.print(" next pop, sb 7 = " + myStack.pop());
        System.out.print(" final pop, sb 6 = " + myStack.pop());
        System.out.println();

        /*
         * TEST PRIORITY QUEUE
         */

        PriorityQueue priorityQ = new PriorityQueue(9);

        System.out.println();
        priorityQ.zeroOut();
        priorityQ.insert(1);
        priorityQ.insert(33);
        priorityQ.insert(23);
        priorityQ.insert(2);
        priorityQ.insert(17);
        priorityQ.insert(95);
        priorityQ.insert(6);
        priorityQ.insert(6);
        priorityQ.insert(7);

        System.out.println(" before starting array is " + priorityQ.curElems());
        System.out.println(" largest sb 95 = " + priorityQ.getLargest());
        System.out.println(" next largest sb 33 = " + priorityQ.getLargest());
        System.out.println(" smallest sb 1 = " + priorityQ.remove());
        System.out.println(" next smallest sb 2 = " + priorityQ.remove());

    } // void main()

}   // Class TestClass.java
