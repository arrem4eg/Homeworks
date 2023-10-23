package homework10.Employee;

public class Developer extends Employee{

    private String programmingLanguage;

    public Developer(String name, String address, double salary, String jobTitle, String programmingLanguage) {
        super(name, address, salary, jobTitle);
        this.programmingLanguage = programmingLanguage;
    }

    public String calculateBonus() {
        return "Developer's Bonus for " + getName() + " " + getSalary() * 0.10;
    }

    public void getPerformanceReport() {

        System.out.println("Performance report for " + getJobTitle() + " " + getName() + ": Good");
    }

    public void getDeveloperWorkInfo() {
        System.out.println("Developer " + getName() + " is writing code in " + programmingLanguage);
    }
}
