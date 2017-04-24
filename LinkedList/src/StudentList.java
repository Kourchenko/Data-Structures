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
    }

    public void insertHead(Student s) {

        /**
         * Insert a link pointing to s at the head of the list.
         */

        if (head == null) {                         // No link(s) exist; create a new Link
            head = s;
            tail = s;
            nStudents++;
            System.out.println(head.getName());
        }
        System.out.println("HEAD Student: " + head.getName());
        s.setNext(head);
        head = s;
        nStudents++;
    }   // void insertHead(Student s)

    public void insertTail(Student s) {

        /**
         * Insert a link pointing to s at the end of the list.
         */


        if (tail == null) {
            head = s;
            tail = s;
            nStudents++;
        }

        tail.setNext(s);
        tail = s;
        nStudents++;
    }   // void insertTail(Student s)


    public Student deleteHead() {

        /**
         * Delete first link and return its value.
         * Throw exception if file is empty.
         */

        try {
            if (head == null) {
                throw new EmptyStackException();
            } else if (head.getNext() != null) {
                Student tmp = head;
                head = tmp;
                return tmp;

            } else if (head.getNext() == null) {
                Student tmp = head;
                head = null;
                return tmp;

            } else {
                return null;
            }

        } catch(EmptyStackException e) {
            return null;
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

        Student next = head;

        if (head == null) {
            return false;
        }

        while (next != null) {
            if (next.getNext().getName().equals(name)) {
                next.setNext(next.getNext());
                return true;
            } else {
                next = next.getNext();
            }
        }
        return false;
    }   // boolean deleteKey(String name)

    public String displayStudents() {

        Student s = head;
        String displayString = "";

        while (s != null) {
            displayString += s.getName() + " ";
            s = s.getNext();
        }

        return displayString;
    }

    public static void main(String[] args) {
        StudentList studentList = new StudentList();

        Student steve = new Student();
        Student bob = new Student();

        steve.setName("Steve");
        bob.setName("Bob");

        studentList.insertHead(steve);

        System.out.println(studentList.displayStudents());
    }

}   // Class StudentList
