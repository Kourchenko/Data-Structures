import java.util.EmptyStackException;


public class StudentList {

    private Student head;
    private Student tail;
    private int nStudents;

    /**
     * List of Class Student(s)
     * - void insertHead(Student s)
     * - void insertTail(Student s)
     * - Student deleteHead()
     * - boolean isEmpty()
     * - boolean findKey(String name)
     * - boolean deleteKey(String name)
     *
     */

    StudentList() {
        head = null;
        tail = null;
        nStudents = 0;
    }

    public void insertHead(Student s) {

        /**
         * Insert a link pointing to s at the head of the list.
         */

        if (head == null) {                         // No link(s) exist; create a new Link
            head = s;
            tail = s;
            nStudents++;
        }
        else {
            s.setNext(head);
            head = s;
            nStudents++;
        }
    }   // void insertHead(Student s)

    public void insertTail(Student s) {

        /**
         * Insert a link pointing to s at the end of the list.
         */

        Student newS = s;
        if (tail == null) {
            head = newS;
            tail = newS;
            nStudents++;
        }
        else {
            tail.setNext(newS);
            tail = s;
            nStudents++;
        }
    }   // void insertTail(Student s)

    public Student deleteHead() {

        /**
         * Delete first link and return its value.
         * Throw exception if file is empty.
         */

        try {
            if (head == null) {
                throw new Error();

            }

            Student tmp = head;
            head = head.getNext();
            nStudents--;
            if (head == null) {
                tail = null;
                throw new EmptyStackException();
            }

            return tmp;


        } catch(EmptyStackException e) {
            return head;
        }
    }   // Student deleteHead()

    public boolean isEmpty() {

        /**
         * Return true if list is empty.
         */

        return (nStudents==0);
    }   // boolean isEmpty()

    public boolean findKey(String name) {

        /**
         * Return true if a link exists containing a Student with the name
         */

        Student next = head;
        while (next != null) {
            if (next.getName().equals(name)) {
                return true;
            } else {
                next = next.getNext();
            }
        }
        return false;
    }   // boolean findKey(String name)

    public boolean deleteKey(String name) {

        /**
         * Delete the first link you find that contains a Student with a name.
         * Return true if found.
         */

        Student curr = head;
        Student prev = head;

        if (curr == null) {
            return false;
        }

        if (curr.getName().equals(name)) {              // HEAD
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return true;
        }
        while (curr.getNext() != null) {
            prev = curr;
            curr = curr.getNext();

            if (curr.getName().equals(name)) {
                prev.setNext(curr);
                if (prev.getNext() == null) {
                    tail = prev;
                }
                return true;
            }
        }

        return false;
    }   // boolean deleteKey(String name)

    public String displayStudents() {

        Student next = head;
        String displayString = "";

        if (head == null) {
            return displayString;
        }

        while (next != null) {
            displayString += next.getName() + " ";
            next = next.getNext();
        }

        return displayString;
    }

    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        Student frodo = new Student("Frodo", 30);

        studentList.insertHead(frodo);

        System.out.println(studentList.displayStudents());
        System.out.println(frodo.getName());



    }

}   // Class StudentList
