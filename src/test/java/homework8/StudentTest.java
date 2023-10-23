package homework8;


public class StudentTest {
    public static void main(String[] args) {

        Student student = new Student();

        System.out.println("об'єкт класу Student зі значеннями за замовчуванням:");
        student.displayStudentInfo(student);

        System.out.println("--------------------------\n");

        System.out.println("значення поля імені студента = null");
        student.setName(null);
        student.displayStudentInfo(student);

        System.out.println("--------------------------\n");

        student.displayStudentInfo(student = null);


    }


}
