package homework10.Employee;

public class QA extends Employee {

    private String programmingLanguage;

    public QA(String name, String address, double salary, String jobTitle, String programmingLanguage) {
        super(name, address, salary, jobTitle);
        this.programmingLanguage = programmingLanguage;
    }

    public String calculateBonus() {
        return "QA's Bonus for " + getName() + " " + getSalary() * 0.10;
    }

    public void getPerformanceReport() {

        System.out.println("Performance report for " + getJobTitle() + " " + getName() + ": Excellent");
    }

    public void getQaWorkInfo() {
        System.out.println("Qa " + getName() + " is using " + programmingLanguage + " for test.");
    }
}
