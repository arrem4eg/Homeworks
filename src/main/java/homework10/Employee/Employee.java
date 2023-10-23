package homework10.Employee;

import java.util.Objects;

public class Employee {

    private String name;
    private String address;
    private double salary;
    private String jobTitle;

    public Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String calculateBonus() {

        return "Bonus: 0.0";
    }

    public void getPerformanceReport() {

        System.out.println("No employee report.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0
                && Objects.equals(name, employee.name)
                && Objects.equals(address, employee.address)
                && Objects.equals(jobTitle, employee.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, salary, jobTitle);
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", jobTitle='" + jobTitle + '\'' +
                " }";
    }
}