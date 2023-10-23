package homework8;

public class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "Emma";
        this.age = 13;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayStudentInfo(Student student) {
        if (student != null) {
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
        } else {
            System.out.println("дані відсутні");
        }
    }
}
