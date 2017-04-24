public class Student {

    /**
     * Student Class
     * - String name
     * - int age
     *
     */

    // FIELDS
    private String name;
    private int age;
    private Student next;

    Student() {
        name = "";
        age = 0;
        next = null;
    }   // Constructor StudentList()

    public void setNext(Student s) {
        next = s;
    }   // void setNext(Student s)

    public Student getNext() {
        return next;
    }   // Student getNext()

    public void setName(String n) {
        name = n;
    }   // void setName()

    public String getName() {
        return name;
    }   // void getName()

    public void setAge(int a) {
        age = a;
    }   // void setAge(int a)

    public int getAge() {
        return age;
    }   // int getAge()

}   // Class StudentList
