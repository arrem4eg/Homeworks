package homework10.Employee;

public class Manager extends Employee {
    private String work;

    public Manager(String name, String address, double salary, String jobTitle,String work) {
        super(name, address, salary, jobTitle);
        this.work = work;

    }

    public String calculateBonus() {
        return "Manager's Bonus for " + getName() + " " + getSalary() * 0.15;
    }

    public void getPerformanceReport() {

        System.out.println("Performance report for " + getJobTitle() + " " + getName() + ": Good");
    }

    public void getManageWorkInfo() {
        System.out.println("Manager " + getName() + " is writing " + work);
    }



}
