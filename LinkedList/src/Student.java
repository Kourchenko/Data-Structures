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

    Student(String n, int a) {
        name = n;
        age = a;
        next = null;
    }   // Constructor StudentList()

    public void setNext(Student n) {
        next = n;
    }
    public Student getNext() {
        return next;
    }
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
