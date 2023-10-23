package homework7;

import org.testng.annotations.Test;

public class PersonTest {
    Person person1 = new Person("Stan", 7);
    Person person2 = new Person("Eric", 8);

    @Test
    public void getPersonInfo1() {
        System.out.println("Name: " + person1.getName() + ", age: " + person1.getAge());


    }

    @Test
    public void getPersonInfo2() {
        System.out.println("Name: " + person2.getName() + ", age: " + person2.getAge());
    }

}


