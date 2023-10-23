package homework10.Employee;

import org.testng.annotations.Test;

public class EmployeeTest {


    Manager manager = new Manager("Eric Cartman", "28201 E. Bonanza St.", 3000.0, "Manager", "Project documentation");
    Developer developer = new Developer("Stan Marsh", "260 Ave. de Los Mexicanos", 2000.0, "Developer", "C#");
    QA qa1 = new QA("Kenny McCormick", "635 Avenue de Los Mexicanos", 1500.0, "QA", "Java");
    QA qa2 = new QA("Kyle Broflovski", "1002 Avenue de los Mexicanos", 1700.0, "QA", "Java");


    @Test
    public void getBonus() {

        System.out.println(manager.calculateBonus());
        System.out.println(developer.calculateBonus());
        System.out.println(qa1.calculateBonus());
        System.out.println(qa2.calculateBonus());
        System.out.println("##########################################################\n");
    }

    @Test
    public void generatePerformanceReport() {

        manager.getPerformanceReport();
        developer.getPerformanceReport();
        qa1.getPerformanceReport();
        qa2.getPerformanceReport();
        System.out.println("##########################################################\n");
    }

    @Test
    public void getWorkInfo() {

        manager.getManageWorkInfo();
        developer.getDeveloperWorkInfo();
        qa1.getQaWorkInfo();
        qa2.getQaWorkInfo();
        System.out.println("##########################################################\n");
    }


    @Test
    public void testEqualAndHashCode() {
        System.out.println("Is qa1 equels qa2 ?: " + qa1.equals(qa2));
        System.out.println("Is qa1's Job Title equels qa2's Job Title ?: " + qa1.getJobTitle().equals(qa2.getJobTitle()));
        System.out.println("qa1's hashCode: " + qa1.hashCode());
        System.out.println("Manager 'toString': " + manager.toString());

    }
}
